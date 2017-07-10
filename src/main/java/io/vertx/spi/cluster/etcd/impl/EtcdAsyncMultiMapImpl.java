package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.PutResponse;
import com.coreos.jetcd.api.RangeRequest;
import com.coreos.jetcd.api.RangeResponse;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.spi.cluster.AsyncMultiMap;
import io.vertx.core.spi.cluster.ChoosableIterable;

import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMultiMapImpl<K, V> implements AsyncMultiMap<K, V> {

  private String name;

  private KVGrpc.KVVertxStub kvStub;

  public EtcdAsyncMultiMapImpl(String name, ManagedChannel channel) {
    this.kvStub = KVGrpc.newVertxStub(channel);
    this.name = name;
  }

  @Override
  public void add(K k, V v, Handler<AsyncResult<Void>> handler) {
    Future
      .<PutResponse>future(putFuture ->
        kvStub.put(
          PutRequest.newBuilder()
            .setKey(ByteString
              .copyFromUtf8(name + "/" + k.toString() + "/" + v.toString()))
            .setValue(toByteString(v))
            .build(),
          putFuture)
      )
      .map((Void)null)
      .setHandler(handler);
  }

  @Override
  public void get(K k, Handler<AsyncResult<ChoosableIterable<V>>> handler) {
    Future
      .<RangeResponse>future(rangeFuture ->
        kvStub.range(
          RangeRequest.newBuilder()
            .setKey(
              ByteString.copyFromUtf8(name + "/" + k.toString() + "/")
            )
            .setRangeEnd(
              ByteString.copyFromUtf8(name + "/" + k.toString() + "0")
            )
            .build(),
          rangeFuture)
      )
      .<ChoosableIterable<V>>map(KeyValueIterable::new)
      .setHandler(handler);
  }

  @Override
  public void remove(K k, V v, Handler<AsyncResult<Boolean>> handler) {
    System.out.println("remove");
  }

  @Override
  public void removeAllForValue(V v, Handler<AsyncResult<Void>> handler) {
    System.out.println("removeAllForValue");

  }

  @Override
  public void removeAllMatching(Predicate<V> p, Handler<AsyncResult<Void>> handler) {
    System.out.println("removeAllMatching");
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
