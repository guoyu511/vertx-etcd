package io.vertx.spi.cluster.etcd;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.coreos.jetcd.api.Event;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.KeyValue;
import com.coreos.jetcd.api.LeaseGrantRequest;
import com.coreos.jetcd.api.LeaseGrantResponse;
import com.coreos.jetcd.api.LeaseGrpc;
import com.coreos.jetcd.api.LeaseKeepAliveRequest;
import com.coreos.jetcd.api.LeaseRevokeRequest;
import com.coreos.jetcd.api.LeaseRevokeResponse;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.PutResponse;
import com.coreos.jetcd.api.WatchCancelRequest;
import com.coreos.jetcd.api.WatchCreateRequest;
import com.coreos.jetcd.api.WatchGrpc;
import com.coreos.jetcd.api.WatchRequest;
import com.coreos.jetcd.api.WatchResponse;
import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.shareddata.AsyncMap;
import io.vertx.core.shareddata.Counter;
import io.vertx.core.shareddata.Lock;
import io.vertx.core.spi.cluster.AsyncMultiMap;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.core.spi.cluster.NodeListener;
import io.vertx.grpc.GrpcBidiExchange;
import io.vertx.grpc.VertxChannelBuilder;
import io.vertx.spi.cluster.etcd.impl.CounterImpl;
import io.vertx.spi.cluster.etcd.impl.EtcdAsyncMapImpl;
import io.vertx.spi.cluster.etcd.impl.EtcdAsyncMultiMapImpl;
import io.vertx.spi.cluster.etcd.impl.EtcdSyncMapImpl;
import io.vertx.spi.cluster.etcd.impl.KeyPath;
import io.vertx.spi.cluster.etcd.impl.LockImpl;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdClusterManager implements ClusterManager {

  private static final long KEEP_ALIVE_TIME = 5l;

  private String host;

  private int port;

  private String prefix;

  private Vertx vertx;

  private ManagedChannel managedChannel;

  private ManagedChannel rawChannel;

  private NodeListener nodeListener;

  private KVGrpc.KVVertxStub kvStub;

  private LeaseGrpc.LeaseVertxStub leaseStub;

  private WatchGrpc.WatchVertxStub watchStub;

  private KeyPath nodePath;

  private ConcurrentHashMap<ByteString, String> nodeCache = new ConcurrentHashMap<>();

  private Long keepAliveTimerId;

  private Long sharedLease;

  private Long watchId;

  private volatile GrpcBidiExchange<WatchResponse, WatchRequest> watchExchange;

  private volatile boolean active;

  private volatile String nodeId;

  public EtcdClusterManager(String host, int port) {
    this(host, port, "vertx");
  }

  public EtcdClusterManager(String host, int port, String prefix) {
    this.host = host;
    this.port = port;
    this.prefix = prefix;
    this.nodePath = KeyPath.path(prefix + "/cluster/nodes");
  }

  @Override
  public void setVertx(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public <K, V> void getAsyncMultiMap(String name, Handler<AsyncResult<AsyncMultiMap<K, V>>> handler) {
    vertx.runOnContext((ignore) -> {
      long lease = name.equals("__vertx.subs") ? sharedLease : 0;
      EtcdAsyncMultiMapImpl<K, V> map = new EtcdAsyncMultiMapImpl<>(
        KeyPath.path(prefix + "/multimaps/" + name), lease, managedChannel);
      map.init(handler);
    });
  }

  @Override
  public <K, V> void getAsyncMap(String name, Handler<AsyncResult<AsyncMap<K, V>>> handler) {
    vertx.runOnContext((ignore) ->
      handler.handle(Future.succeededFuture(
        new EtcdAsyncMapImpl<>(KeyPath.path(prefix + "/maps/" + name), managedChannel)))
    );
  }

  @Override
  public <K, V> Map<K, V> getSyncMap(String name) {
    return new EtcdSyncMapImpl<>(KeyPath.path(prefix + "/maps/" + name), sharedLease, rawChannel);
  }

  @Override
  public void getLockWithTimeout(String name, long timeout, Handler<AsyncResult<Lock>> handler) {
    vertx.runOnContext((ignore) -> {
      LockImpl lock = new LockImpl(name, timeout, sharedLease, managedChannel, vertx);
      lock.aquire(handler);
    });
  }

  @Override
  public void getCounter(String name, Handler<AsyncResult<Counter>> handler) {
    vertx.runOnContext((ignore) ->
      handler.handle(Future.succeededFuture(
        new CounterImpl(prefix + "/counters/" + name, sharedLease, managedChannel)))
    );
  }

  @Override
  public String getNodeID() {
    return nodeId;
  }

  @Override
  public List<String> getNodes() {
    return new ArrayList<>(nodeCache.values());
  }

  @Override
  public void nodeListener(NodeListener listener) {
    this.nodeListener = listener;
  }

  @Override
  public void join(Handler<AsyncResult<Void>> handler) {
    vertx.runOnContext(v -> {
      nodeId = UUID.randomUUID().toString();
      managedChannel = VertxChannelBuilder.forAddress(vertx, host, port)
        .usePlaintext(true)
        .build();
      rawChannel = NettyChannelBuilder.forAddress(host, port)
        .usePlaintext(true)
        .build();
      leaseStub = LeaseGrpc.newVertxStub(managedChannel);
      kvStub = KVGrpc.newVertxStub(managedChannel);
      watchStub = WatchGrpc.newVertxStub(managedChannel);
      startKeepAlive()
        .compose(lease -> Future.<PutResponse>future(fut ->
          kvStub.put(PutRequest.newBuilder()
            .setLease(sharedLease)
            .setKey(nodePath.getKey(nodeId))
            .setValue(toByteString(nodeId))
            .build(), fut)))
        .compose(res -> {
          long rev = res.getHeader().getRevision();
          nodeCache.put(nodePath.getKey(nodeId), nodeId);
          return startWatch(rev);
        })
        .<Void>map(ignore -> {
          active = true;
          return null;
        })
        .setHandler(handler);
    });
  }

  @Override
  public void leave(Handler<AsyncResult<Void>> handler) {
    vertx.runOnContext(v ->
      stopWatch()
        .compose(ignore -> this.stopKeepAlive())
        .compose(ignore -> {
          Future<Void> shutdownFuture = Future.future();
          vertx.executeBlocking((blcFuture) -> {
            try {
              managedChannel.shutdown();
              managedChannel.awaitTermination(10, TimeUnit.SECONDS);
              rawChannel.shutdown();
              rawChannel.awaitTermination(10, TimeUnit.SECONDS);
              active = false;
              blcFuture.complete();
            } catch (InterruptedException e) {
              blcFuture.fail(e);
            }
          }, shutdownFuture);
          return shutdownFuture;
        })
        .setHandler(handler)
    );
  }

  @Override
  public boolean isActive() {
    return active;
  }

  private Future<Void> startKeepAlive() {
    return Future.<LeaseGrantResponse>future(fut ->
      leaseStub.leaseGrant(
        LeaseGrantRequest.newBuilder()
          .setTTL(KEEP_ALIVE_TIME)
          .build(), fut))
      .map(res -> {
        sharedLease = res.getID();
        leaseStub.leaseKeepAlive(exchange ->
          keepAliveTimerId = vertx.setPeriodic(KEEP_ALIVE_TIME / 2, (ignore) -> {
            exchange.write(LeaseKeepAliveRequest.newBuilder()
              .setID(sharedLease)
              .build());
          }));
        return null;
      });
  }

  private Future<Void> stopKeepAlive() {
    if (keepAliveTimerId != null) {
      vertx.cancelTimer(keepAliveTimerId);
    }
    if (sharedLease == null) {
      return Future.succeededFuture();
    }
    return Future.<LeaseRevokeResponse>future(fut ->
      leaseStub.leaseRevoke(
        LeaseRevokeRequest.newBuilder()
          .setID(sharedLease)
          .build(), fut))
      .mapEmpty();
  }

  private Future<Void> startWatch(long rev) {
    Future<Void> future = Future.future();
    watchStub.watch(exchange -> {
      watchExchange = exchange;
      watchExchange
        .write(WatchRequest.newBuilder()
          .setCreateRequest(WatchCreateRequest.newBuilder()
            .setStartRevision(rev)
            .setKey(nodePath.rangeBegin())
            .setPrevKv(true)
            .setRangeEnd(nodePath.rangeEnd())
          )
          .build())
        .handler(watchRes -> {
          if (watchRes.getCreated()) {
            watchId = watchRes.getWatchId();
            future.complete();
          } else {
            this.handleEvents(watchRes.getEventsList());
          }
        })
        .exceptionHandler(future::fail);;
    });
    return future;
  }

  private Future<Void> stopWatch() {
    if (watchId == null) {
      return Future.succeededFuture();
    }
    Future<Void> future = Future.future();
    watchExchange.write(
      WatchRequest.newBuilder()
        .setCancelRequest(
          WatchCancelRequest.newBuilder()
            .setWatchId(watchId)
        )
        .build())
      .handler(watchRes -> {
        if (watchRes.getCanceled()) {
          watchId = watchRes.getWatchId();
          future.complete();
        } else {
          this.handleEvents(watchRes.getEventsList());
        }
      })
      .exceptionHandler(future::fail);
    return future;
  }

  private void handleEvents(List<Event> events) {
    events.forEach(event -> {
      KeyValue kv = event.getKv();
      if (Objects.equals(kv.getKey(), nodePath.getKey(this.nodeId))) {
        return;
      }
      if (event.getType() == Event.EventType.PUT) {
        String nodeId = fromByteString(kv.getValue());
        nodeCache.put(kv.getKey(), nodeId);
        if (nodeListener != null) {
          nodeListener.nodeAdded(nodeId);
        }
      } else if (event.getType() == Event.EventType.DELETE) {
        nodeCache.remove(kv.getKey());
        if (nodeListener != null) {
          nodeListener.nodeLeft(nodeId);
        }
      }
    });
  }

}
