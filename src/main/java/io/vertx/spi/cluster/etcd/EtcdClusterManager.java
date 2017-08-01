package io.vertx.spi.cluster.etcd;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.Event;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.KeyValue;
import com.coreos.jetcd.api.LeaseGrantRequest;
import com.coreos.jetcd.api.LeaseGrpc;
import com.coreos.jetcd.api.LeaseKeepAliveRequest;
import com.coreos.jetcd.api.LeaseKeepAliveResponse;
import com.coreos.jetcd.api.LeaseRevokeRequest;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.WatchCreateRequest;
import com.coreos.jetcd.api.WatchGrpc;
import com.coreos.jetcd.api.WatchRequest;
import com.coreos.jetcd.api.WatchResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.netty.channel.nio.NioEventLoopGroup;
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
import io.vertx.spi.cluster.etcd.impl.CounterImpl;
import io.vertx.spi.cluster.etcd.impl.EtcdAsyncMapImpl;
import io.vertx.spi.cluster.etcd.impl.EtcdAsyncMultiMapImpl;
import io.vertx.spi.cluster.etcd.impl.EtcdSyncMapImpl;
import io.vertx.spi.cluster.etcd.impl.LockImpl;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdClusterManager implements ClusterManager {

  private String host;

  private int port;

  private String prefix;

  private Vertx vertx;

  private ManagedChannel managedChannel;

  private NodeListener nodeListener;

  private KVGrpc.KVBlockingStub kvStub;

  private LeaseGrpc.LeaseBlockingStub leaseStub;

  private WatchGrpc.WatchStub watchStub;

  private ConcurrentHashMap<String, String> nodeCache = new ConcurrentHashMap<>();

  private NioEventLoopGroup grpcEventLoop;

  private long keepAlivePeriodic;

  private volatile boolean active;

  private volatile String nodeId;

  private volatile long sharedLease;

  private static final String ETCD_CLUSTER_NODES = "cluster/nodes";

  private static final long ETCD_TIMEOUT = 5l;

  public EtcdClusterManager(String host, int port) {
    this(host, port, "vertx");
  }

  public EtcdClusterManager(String host, int port, String prefix) {
    this.host = host;
    this.port = port;
    this.prefix = prefix;
  }

  @Override
  public void setVertx(Vertx vertx) {
    this.vertx = vertx;
  }

  @Override
  public <K, V> void getAsyncMultiMap(String name, Handler<AsyncResult<AsyncMultiMap<K, V>>> asyncResultHandler) {
    vertx.runOnContext((ignore) ->
      asyncResultHandler.handle(Future.succeededFuture(
        new EtcdAsyncMultiMapImpl<>(prefix + "/maps/" + name, managedChannel, vertx)))
    );
  }

  @Override
  public <K, V> void getAsyncMap(String name, Handler<AsyncResult<AsyncMap<K, V>>> asyncResultHandler) {
    vertx.runOnContext((ignore) ->
      asyncResultHandler.handle(Future.succeededFuture(
        new EtcdAsyncMapImpl<>(prefix + "/maps/" + name, managedChannel, vertx)))
    );
  }

  @Override
  public <K, V> Map<K, V> getSyncMap(String name) {
    return new EtcdSyncMapImpl(prefix + "/maps/" + name, sharedLease, managedChannel);
  }

  @Override
  public void getLockWithTimeout(String name, long timeout, Handler<AsyncResult<Lock>> resultHandler) {
    vertx.runOnContext((ignore) -> {
      LockImpl lock = new LockImpl(name, timeout, sharedLease, managedChannel, vertx);
      lock.aquire(resultHandler);
    });
  }

  @Override
  public void getCounter(String name, Handler<AsyncResult<Counter>> resultHandler) {
    vertx.runOnContext((ignore) ->
      resultHandler.handle(Future.succeededFuture(
        new CounterImpl(prefix + "/counters/" + name, sharedLease, managedChannel, vertx)))
    );
  }

  @Override
  public String getNodeID() {
    return nodeId;
  }

  @Override
  public List<String> getNodes() {
    return nodeCache.keySet().stream()
      .collect(Collectors.toList());
  }

  @Override
  public void nodeListener(NodeListener listener) {
    this.nodeListener = listener;
  }

  @Override
  public void join(Handler<AsyncResult<Void>> handler) {
    nodeId = UUID.randomUUID().toString();
    managedChannel = buildChannel();
    leaseStub = LeaseGrpc.newBlockingStub(managedChannel);
    kvStub = KVGrpc.newBlockingStub(managedChannel);
    watchStub = WatchGrpc.newStub(managedChannel);
    vertx.executeBlocking(future -> {
      sharedLease = leaseStub.leaseGrant(LeaseGrantRequest.newBuilder()
        .setTTL(ETCD_TIMEOUT)
        .build()).getID();
      kvStub.put(PutRequest.newBuilder()
        .setLease(sharedLease)
        .setKey(ByteString.copyFromUtf8(prefix + "/" + ETCD_CLUSTER_NODES + "/" + nodeId))
        .setValue(ByteString.copyFromUtf8(nodeId))
        .build());
      watchStub.watch(new NodeObserver())
        .onNext(WatchRequest.newBuilder()
          .setCreateRequest(WatchCreateRequest.newBuilder()
            .setKey(ByteString.copyFromUtf8(prefix + "/" + ETCD_CLUSTER_NODES + "/" ))
            .setRangeEnd(ByteString.copyFromUtf8(prefix + "/" + ETCD_CLUSTER_NODES + "0" ))
          )
          .build());
      startKeepAlive(sharedLease);
      nodeCache.put(prefix + "/" + ETCD_CLUSTER_NODES + "/" + nodeId, nodeId);
      active = true;
      future.complete();
    }, handler);
  }

  @Override
  public void leave(Handler<AsyncResult<Void>> handler) {
    vertx.cancelTimer(keepAlivePeriodic);
    vertx.executeBlocking(future -> {
      leaseStub.leaseRevoke(LeaseRevokeRequest.newBuilder()
        .setID(sharedLease)
        .build());
      managedChannel.shutdown();
      grpcEventLoop.shutdownGracefully();
      future.complete();
    }, handler);
  }

  @Override
  public boolean isActive() {
    return active;
  }

  private ManagedChannel buildChannel() {
    grpcEventLoop = new NioEventLoopGroup(1,
      (ThreadFactory) (r) -> new Thread(r, "vertx-etcd-eventloop"));
    grpcEventLoop.execute(() -> {});  // a little magic, force the nio thread to be created
    return NettyChannelBuilder.forAddress(host, port)
      .eventLoopGroup(grpcEventLoop)
      .usePlaintext(true)
      .build();
  }

  private void startKeepAlive(long lease) {
    LeaseGrpc.LeaseStub stub = LeaseGrpc.newStub(managedChannel);
    StreamObserver<LeaseKeepAliveRequest> observer = stub.leaseKeepAlive(new NoopStreamObserver());
    keepAlivePeriodic = vertx.setPeriodic(ETCD_TIMEOUT / 2, (ignore) -> {
      observer.onNext(LeaseKeepAliveRequest.newBuilder()
        .setID(lease)
        .build());
    });
  }

  private class NodeObserver implements StreamObserver<WatchResponse> {

    @Override
    public void onNext(WatchResponse watchRes) {
      watchRes.getEventsList().forEach(event -> {
        KeyValue kv = event.getKv();
        String nodeId = kv.getValue().toStringUtf8();
        if (event.getType() == Event.EventType.PUT) {
          nodeCache.put(kv.getKey().toStringUtf8(), nodeId);
          if (nodeListener != null) {
            nodeListener.nodeAdded(nodeId);
          }
        } else if (event.getType() == Event.EventType.DELETE) {
          nodeCache.remove(kv.getKey().toStringUtf8());
          if (nodeListener != null) {
            nodeListener.nodeLeft(nodeId);
          }
        }
      });
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onCompleted() {

    }
  }

  private class NoopStreamObserver implements StreamObserver<LeaseKeepAliveResponse> {

    @Override
    public void onNext(LeaseKeepAliveResponse leaseKeepAliveResponse) {}

    @Override
    public void onError(Throwable throwable) {}

    @Override
    public void onCompleted() {}

  }

}
