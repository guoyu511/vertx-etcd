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
import io.vertx.core.spi.cluster.AsyncMultiMap;
import io.vertx.core.spi.cluster.ChoosableIterable;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMultiMapImpl<K, V> implements AsyncMultiMap<K, V> {

  private Vertx vertx;

  private String name;

  private KVGrpc.KVBlockingStub kvStub;

  private ByteString rangeBegin, rangeEnd;

  public EtcdAsyncMultiMapImpl(String name, ManagedChannel channel, Vertx vertx) {
    this.vertx = vertx;
    this.name = name;
    this.kvStub = KVGrpc.newBlockingStub(channel);
    rangeBegin = toByteString(name + "/");
    rangeEnd = toByteString(name + "0");
  }

  @Override
  public void add(K k, V v, Handler<AsyncResult<Void>> handler) {
    vertx.executeBlocking(future -> {
      kvStub.put(
        PutRequest.newBuilder()
          .setKey(rangeBegin
            .concat(toByteString(k))
            .concat(toByteString("/"))
            .concat(toByteString(v))
          )
          .setValue(toByteString(v))
          .build());
      future.complete();
    }, handler);
  }

  @Override
  public void get(K k, Handler<AsyncResult<ChoosableIterable<V>>> handler) {
    vertx.executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(
        RangeRequest.newBuilder()
          .setKey(rangeBegin
            .concat(toByteString(k)
            .concat(toByteString("/"))
          ))
          .setRangeEnd(rangeBegin
            .concat(toByteString(k)
            .concat(toByteString("0"))
          ))
          .build());
      future.complete(new KeyValueIterable<>(rangeRes));
    }, handler);
  }

  @Override
  public void remove(K k, V v, Handler<AsyncResult<Boolean>> handler) {
    vertx.executeBlocking(future -> {
      DeleteRangeResponse deleteRes = kvStub.deleteRange(
        DeleteRangeRequest.newBuilder()
          .setKey(rangeBegin
            .concat(toByteString(k)
            .concat(toByteString("/"))
            .concat(toByteString(v))
          ))
          .build()
      );
      future.complete(deleteRes.getDeleted() > 0);
    }, handler);
  }

  @Override
  public void removeAllForValue(V v, Handler<AsyncResult<Void>> handler) {
    removeAllMatching((value) -> value.equals(v), handler);

  }

  @Override
  public void removeAllMatching(Predicate<V> p, Handler<AsyncResult<Void>> handler) {
    vertx.executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(
        RangeRequest.newBuilder()
          .setKey(rangeBegin)
          .setRangeEnd(rangeEnd)
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
    }, handler);
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
