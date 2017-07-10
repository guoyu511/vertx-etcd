package io.vertx.spi.cluster.etcd.impl;

import com.google.common.collect.Maps;
import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.RangeRequest;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdSyncMapImpl<K, V> implements Map<K, V> {

  private String name;

  private KVGrpc.KVBlockingStub kvStub;

  public EtcdSyncMapImpl(String name, ManagedChannel channel) {
    this.name = name;
    kvStub = KVGrpc.newBlockingStub(channel);
  }

  @Override
  public int size() {
    return (int) kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build())
      .getCount();
  }

  @Override
  public boolean isEmpty() {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build())
      .getCount() == 0;
  }

  @Override
  public boolean containsKey(Object key) {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/" + key.toString()))
        .build())
      .getCount() == 0;
  }

  @Override
  public boolean containsValue(Object value) {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build())
      .getKvsList()
      .stream()
      .anyMatch((kv) ->
        fromByteString(kv.getValue()).equals(value)
      );
  }

  @Override
  public V get(Object key) {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .build())
      .getKvsList()
      .stream()
      .findFirst()
      .<V>map(kv -> fromByteString(kv.getValue()))
      .orElse(null);
  }

  @Override
  public V put(K key, V value) {
    return fromByteString(kvStub.put(
      PutRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/" + key.toString()))
        .setValue(toByteString(value))
        .setPrevKv(true)
        .build())
      .getPrevKv().getValue());
  }

  @Override
  public V remove(Object key) {
    return kvStub.deleteRange(
      DeleteRangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/" + key.toString()))
        .setPrevKv(true)
        .build())
      .getPrevKvsList()
      .stream()
      .findFirst()
      .<V>map(kv -> fromByteString(kv.getValue()))
      .orElse(null);
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    m.forEach(this::put);
  }

  @Override
  public void clear() {
    kvStub.deleteRange(
      DeleteRangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build());
  }

  @Override
  public Set<K> keySet() {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build())
      .getKvsList()
      .stream()
      .<K>map(kv -> fromByteString(kv.getKey()))
      .collect(Collectors.toSet());
  }

  @Override
  public Collection<V> values() {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build())
      .getKvsList()
      .stream()
      .<V>map(kv -> fromByteString(kv.getValue()))
      .collect(Collectors.toSet());
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    return kvStub.range(
      RangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8(name + "/"))
        .setRangeEnd(ByteString.copyFromUtf8(name + "0"))
        .build())
      .getKvsList()
      .stream()
      .<Entry<K, V>>map(kv -> Maps.immutableEntry(
        fromByteString(kv.getKey()),
        fromByteString(kv.getValue())
      ))
      .collect(Collectors.toSet());
  }

}
