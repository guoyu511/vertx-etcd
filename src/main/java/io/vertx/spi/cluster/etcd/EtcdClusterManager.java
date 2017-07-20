package io.vertx.spi.cluster.etcd;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.LeaseGrantRequest;
import com.coreos.jetcd.api.LeaseGrantResponse;
import com.coreos.jetcd.api.LeaseGrpc;
import com.coreos.jetcd.api.LeaseKeepAliveRequest;
import com.coreos.jetcd.api.LeaseKeepAliveResponse;
import com.coreos.jetcd.api.LeaseRevokeRequest;
import com.coreos.jetcd.api.LeaseRevokeResponse;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.PutResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.channel.nio.NioEventLoopGroup;
import io.vertx.core.AsyncResult;
import io.vertx.core.Context;
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

  private ManagedChannel channelForSyncMap;

  private NodeListener listener;

  private KVGrpc.KVVertxStub kvStub;

  private LeaseGrpc.LeaseVertxStub leaseStub;

  private Map<String, String> nodeCache = new HashMap<>();

  private long keepAlivePeriodic;

  private volatile boolean active;

  private volatile String nodeId;

  private volatile long sharedLease;

  private ConcurrentHashMap<Context, ManagedChannel> channelMap = new ConcurrentHashMap<>();

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
        new EtcdAsyncMultiMapImpl<>(prefix + "/" + name, getChannel())))
    );
  }

  @Override
  public <K, V> void getAsyncMap(String name, Handler<AsyncResult<AsyncMap<K, V>>> asyncResultHandler) {
    vertx.runOnContext((ignore) ->
      asyncResultHandler.handle(Future.succeededFuture(
        new EtcdAsyncMapImpl<>(prefix + "/" + name, getChannel())))
    );
  }

  @Override
  public <K, V> Map<K, V> getSyncMap(String name) {
    return new EtcdSyncMapImpl(prefix + "/" + name, sharedLease, channelForSyncMap);
  }

  @Override
  public void getLockWithTimeout(String name, long timeout, Handler<AsyncResult<Lock>> resultHandler) {
    vertx.runOnContext((ignore) -> {
      LockImpl lock = new LockImpl(name, timeout, sharedLease, getChannel(), vertx);
      lock.aquire(resultHandler);
    });
  }

  @Override
  public void getCounter(String name, Handler<AsyncResult<Counter>> resultHandler) {
    System.out.println("getCounter");
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
    this.listener = listener;
  }

  @Override
  public void join(Handler<AsyncResult<Void>> handler) {

    channelForSyncMap = buildChannelForSyncMap();

    leaseStub = LeaseGrpc.newVertxStub(getChannel());
    kvStub = KVGrpc.newVertxStub(getChannel());

    nodeId = UUID.randomUUID().toString();

    Future
      .<LeaseGrantResponse>future(grantFuture ->
        leaseStub.leaseGrant(
          LeaseGrantRequest.newBuilder()
            .setTTL(ETCD_TIMEOUT)
            .build(),
          grantFuture)
      )
      .map(LeaseGrantResponse::getID)
      .map((lease) -> sharedLease = lease)
      .<PutResponse>compose(lease ->
        Future.future(putFuture ->
          kvStub.put(
            PutRequest.newBuilder()
              .setLease(sharedLease)
              .setKey(key())
              .setValue(ByteString.EMPTY)
              .build(),
            putFuture)
        )
      )
      .<Void>map((res) -> {
        leaseStub.leaseKeepAlive((exchange) ->
          this.keepAlive(sharedLease, exchange));
        active = true;
        return null;
      })
      .setHandler(handler);
  }

  @Override
  public void leave(Handler<AsyncResult<Void>> handler) {
    vertx.cancelTimer(keepAlivePeriodic);
    Future
      .<LeaseRevokeResponse>future(future ->
        leaseStub.leaseRevoke(
          LeaseRevokeRequest.newBuilder()
            .setID(sharedLease)
            .build(),
          future
        )
      )
      .<Void>map((res) -> {
        channelForSyncMap.shutdownNow();
        channelMap.values().forEach(ManagedChannel::shutdownNow);
        return null;
      })
      .setHandler(handler);
  }

  @Override
  public boolean isActive() {
    return active;
  }

  private ManagedChannel getChannel() {
    return channelMap.computeIfAbsent(
      vertx.getOrCreateContext(),
      (ctx) -> {
        ManagedChannel channel = VertxChannelBuilder.forAddress(vertx, host, port)
          .usePlaintext(true)
          .build();
        ctx.addCloseHook(handler -> {
          channel.shutdown();
          channelMap.remove(ctx);
          handler.handle(Future.succeededFuture());
        });
        return channel;
      }
    );
  }

  private ManagedChannel buildChannelForSyncMap() {
    //use split nio event loop because we need perform blocking operator on eventloop thread for syncMap
    NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup(1,
      (ThreadFactory) (r) -> new Thread(r, "vertx-etcd-eventloop"));
    eventLoopGroup.execute(() -> {});  // a little magic, force the nio thread to be created
    return NettyChannelBuilder.forAddress(host, port)
      .eventLoopGroup(eventLoopGroup)
      .usePlaintext(true)
      .build();
  }

  private void keepAlive(long lease, GrpcBidiExchange<LeaseKeepAliveResponse, LeaseKeepAliveRequest> exchange) {
    keepAlivePeriodic = vertx.setPeriodic(ETCD_TIMEOUT / 2, (ignore) ->
      exchange.write(LeaseKeepAliveRequest.newBuilder()
        .setID(lease)
        .build())
    );
  }

  private ByteString key() {
    return ByteString.copyFromUtf8(prefix + "/" + ETCD_CLUSTER_NODES + "/" + nodeId);
  }

}
