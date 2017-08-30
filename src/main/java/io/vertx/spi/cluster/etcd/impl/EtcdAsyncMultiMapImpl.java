package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.DeleteRangeResponse;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.RangeRequest;
import com.coreos.jetcd.api.RangeResponse;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.impl.ContextImpl;
import io.vertx.core.impl.TaskQueue;
import io.vertx.core.spi.cluster.AsyncMultiMap;
import io.vertx.core.spi.cluster.ChoosableIterable;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMultiMapImpl<K, V> implements AsyncMultiMap<K, V> {

  private Vertx vertx;

  private KVGrpc.KVBlockingStub kvStub;

  private String rangeBegin, rangeEnd;

  private long lease;

  private TaskQueue taskQueue;

  //TODO performance enhancement, using in memory cache for multimap
  public EtcdAsyncMultiMapImpl(String name, long lease, ManagedChannel channel, Vertx vertx) {
    this.vertx = vertx;
    this.kvStub = KVGrpc.newBlockingStub(channel);
    this.lease = lease;
    this.taskQueue = new TaskQueue();
    rangeBegin = name + "/";
    rangeEnd = name + "0";
  }

  @Override
  public void add(K k, V v, Handler<AsyncResult<Void>> handler) {
    getContext().executeBlocking(future -> {
      kvStub.put(
        PutRequest.newBuilder()
          .setKey(ByteString.copyFromUtf8(
            rangeBegin + k + "/" + v
          ))
          .setValue(toByteString(v))
          .setLease(lease)
          .build());
      future.complete();
    }, taskQueue, handler);
  }

  @Override
  public void get(K k, Handler<AsyncResult<ChoosableIterable<V>>> handler) {
    getContext().executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(
        RangeRequest.newBuilder()
          .setKey(ByteString.copyFromUtf8(
            rangeBegin + k + "/"
          ))
          .setRangeEnd(ByteString.copyFromUtf8(
            rangeBegin + k + "0"
          ))
          .build());
      future.complete(new KeyValueIterable<>(rangeRes));
    }, taskQueue, handler);
  }

  @Override
  public void remove(K k, V v, Handler<AsyncResult<Boolean>> handler) {
    getContext().executeBlocking(future -> {
      DeleteRangeResponse deleteRes = kvStub.deleteRange(
        DeleteRangeRequest.newBuilder()
          .setKey(ByteString.copyFromUtf8(
            rangeBegin + k + "/" + v
          ))
          .build()
      );
      future.complete(deleteRes.getDeleted() > 0);
    }, taskQueue, handler);
  }

  @Override
  public void removeAllForValue(V v, Handler<AsyncResult<Void>> handler) {
    removeAllMatching((value) -> value.equals(v), handler);

  }

  @Override
  public void removeAllMatching(Predicate<V> p, Handler<AsyncResult<Void>> handler) {
    getContext().executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(
        RangeRequest.newBuilder()
          .setKey(ByteString.copyFromUtf8(rangeBegin))
          .setRangeEnd(ByteString.copyFromUtf8(rangeEnd))
          .build());
      rangeRes.getKvsList()
        .stream()
        .filter(kv ->  p.test(fromByteString(kv.getValue())))
        .map(kv -> kv.getKey())
        .forEach(k ->
          kvStub.deleteRange(
            DeleteRangeRequest.newBuilder()
              .setKey(k)
              .build()
          ));
      future.complete();
    }, taskQueue, handler);
  }

  private ContextImpl getContext() {
    return ((ContextImpl)vertx.getOrCreateContext());
  }

  private static class KeyValueIterable<V> implements ChoosableIterable<V> {

    private List<V> list;

    private AtomicInteger counter = new AtomicInteger(0);

    KeyValueIterable(RangeResponse rangeResponse) {
      this.list = rangeResponse.getKvsList().stream()
        .map(kv -> kv.getValue())
        .<V>map(Codec::fromByteString)
        .collect(Collectors.toList());
    }

    @Override
    public boolean isEmpty() {
      return list.isEmpty();
    }

    @Override
    public V choose() {
      return list.get(
        Math.abs(counter.getAndIncrement() % list.size()));
    }

    @Override
    public Iterator<V> iterator() {
      return list.iterator();
    }

  }

}
