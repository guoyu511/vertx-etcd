package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.Compare;
import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.DeleteRangeResponse;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.KeyValue;
import com.coreos.jetcd.api.LeaseGrantRequest;
import com.coreos.jetcd.api.LeaseGrantResponse;
import com.coreos.jetcd.api.LeaseGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.PutResponse;
import com.coreos.jetcd.api.RangeRequest;
import com.coreos.jetcd.api.RangeResponse;
import com.coreos.jetcd.api.RequestOp;
import com.coreos.jetcd.api.TxnRequest;
import com.coreos.jetcd.api.TxnResponse;

import io.grpc.ManagedChannel;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.shareddata.AsyncMap;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMapImpl<K, V> implements AsyncMap<K, V> {

  private KVGrpc.KVVertxStub kvStub;

  private LeaseGrpc.LeaseVertxStub leaseStub;

  private String name;

  private ByteString rangeBegin, rangeEnd;

  public EtcdAsyncMapImpl(String name, ManagedChannel channel) {
    this.kvStub = KVGrpc.newVertxStub(channel);
    this.leaseStub = LeaseGrpc.newVertxStub(channel);
    this.name = name;
    rangeBegin = ByteString.copyFromUtf8(name + "/");
    rangeEnd = ByteString.copyFromUtf8(name + "0"); // '0' is the next char of '/'
  }

  @Override
  public void get(K k, Handler<AsyncResult<V>> handler) {
    Future
      .<RangeResponse>future(rangeFuture ->
        kvStub.range(
          RangeRequest.newBuilder()
            .setKey(keyPath(k)).build(),
          rangeFuture)
      )
      .<V>map((res) -> {
        if (res.getCount() == 0) {
          return null;
        }
        KeyValue kv = res.getKvs(0);
        return fromByteString(kv.getValue());
      })
      .setHandler(handler);
  }

  @Override
  public void put(K k, V v, Handler<AsyncResult<Void>> handler) {
    Future
      .<PutResponse>future(putFuture ->
        kvStub.put(
          PutRequest.newBuilder()
            .setKey(keyPath(k))
            .setValue(toByteString(v))
            .build(),
          putFuture)
      )
      .map((Void)null)
      .setHandler(handler);
  }

  @Override
  public void put(K k, V v, long ttl, Handler<AsyncResult<Void>> handler) {
    Future
      .<LeaseGrantResponse>future(grantFuture ->
        leaseStub.leaseGrant(
          LeaseGrantRequest.newBuilder()
            .setTTL(ttl / 1000) // cast ms to sec
            .build(),
          grantFuture)
      )
      .map(LeaseGrantResponse::getID)
      .compose(lease ->
        Future.<PutResponse>future(putFuture ->
          kvStub.put(
            PutRequest.newBuilder()
              .setLease(lease)
              .setKey(keyPath(k))
              .setValue(toByteString(v))
              .build(),
            putFuture))
      )
      .map((Void)null)
      .setHandler(handler);
  }

  @Override
  public void putIfAbsent(K k, V v, Handler<AsyncResult<V>> handler) {
    Future
      .<TxnResponse>future(txnFuture ->
        kvStub.txn(
          TxnRequest.newBuilder()
            .addCompare(Compare.newBuilder()
              .setKey(keyPath(k))
              .setTarget(Compare.CompareTarget.VERSION)
              .setResult(Compare.CompareResult.LESS)
              .setVersion(1)
            )
            .addSuccess(RequestOp.newBuilder()
              .setRequestPut(PutRequest.newBuilder()
                .setKey(keyPath(k))
                .setValue(toByteString(v)))
            )
            .addFailure(RequestOp.newBuilder()
              .setRequestRange(RangeRequest.newBuilder()
                .setKey(keyPath(k)))
            )
            .build(),
          txnFuture)
      )
      .<V>map(txnResponse -> {
        if (txnResponse.getSucceeded()) {
          return null;
        }
        return fromByteString(txnResponse.getResponses(0)
          .getResponseRange().getKvs(0).getValue());
      })
      .setHandler(handler);
  }

  @Override
  public void putIfAbsent(K k, V v, long ttl, Handler<AsyncResult<V>> handler) {
    Future
      .<LeaseGrantResponse>future(grantFuture ->
        leaseStub.leaseGrant(
          LeaseGrantRequest.newBuilder()
            .setTTL(ttl / 1000) // cast ms to sec
            .build(),
          grantFuture)
      )
      .map(LeaseGrantResponse::getID)
      .compose(lease ->
        Future.<TxnResponse>future(txnFuture ->
          kvStub.txn(
            TxnRequest.newBuilder()
              .addCompare(Compare.newBuilder()
                .setKey(keyPath(k))
                .setTarget(Compare.CompareTarget.VERSION)
                .setResult(Compare.CompareResult.LESS)
                .setVersion(1)
              )
              .addSuccess(RequestOp.newBuilder()
                .setRequestPut(PutRequest.newBuilder()
                  .setKey(keyPath(k))
                  .setValue(toByteString(v)))
              )
              .addFailure(RequestOp.newBuilder()
                .setRequestRange(RangeRequest.newBuilder()
                  .setKey(keyPath(k)))
              )
              .build(),
            txnFuture)
        )
      )
      .<V>map(txnResponse -> {
        if (txnResponse.getSucceeded()) {
          return null;
        }
        return fromByteString(txnResponse.getResponses(0)
          .getResponseRange().getKvs(0).getValue());
      })
      .setHandler(handler);
  }

  @Override
  public void remove(K k, Handler<AsyncResult<V>> handler) {
    Future
      .<DeleteRangeResponse>future(deleteFuture ->
        kvStub.deleteRange(
          DeleteRangeRequest.newBuilder()
            .setKey(keyPath(k))
            .setPrevKv(true)
            .build(),
          deleteFuture)
      )
      .map(res -> res.getPrevKvsList().stream().findFirst())
      .map(opt -> opt.map(kv ->
        (V)fromByteString(kv.getValue())).orElse(null))
      .setHandler(handler);
  }

  @Override
  public void removeIfPresent(K k, V v, Handler<AsyncResult<Boolean>> handler) {
    Future
      .<TxnResponse>future(txnFuture ->
        kvStub.txn(
          TxnRequest.newBuilder()
            .addCompare(Compare.newBuilder()
              .setKey(keyPath(k))
              .setTarget(Compare.CompareTarget.VALUE)
              .setResult(Compare.CompareResult.EQUAL)
              .setValue(toByteString(v))
            )
            .addSuccess(RequestOp.newBuilder()
              .setRequestDeleteRange(DeleteRangeRequest.newBuilder()
                .setKey(keyPath(k)))
            )
            .build(),
          txnFuture)
      )
      .map(txnResponse -> txnResponse.getSucceeded())
      .setHandler(handler);
  }

  @Override
  public void replace(K k, V v, Handler<AsyncResult<V>> handler) {
    Future
      .<TxnResponse>future(txnFuture ->
        kvStub.txn(
          TxnRequest.newBuilder()
            .addCompare(Compare.newBuilder()
              .setKey(keyPath(k))
              .setTarget(Compare.CompareTarget.VERSION)
              .setResult(Compare.CompareResult.GREATER)
              .setVersion(0)
            )
            .addSuccess(RequestOp.newBuilder()
              .setRequestPut(PutRequest.newBuilder()
                .setKey(keyPath(k))
                .setPrevKv(true)
                .setValue(toByteString(v)))
            )
            .build(),
          txnFuture)
      )
      .<V>map(txnResponse -> {
        if (!txnResponse.getSucceeded()) {
          return null;
        }
        return fromByteString(txnResponse.getResponses(0)
          .getResponsePut().getPrevKv().getValue());
      })
      .setHandler(handler);
  }

  @Override
  public void replaceIfPresent(K k, V oldValue, V newValue, Handler<AsyncResult<Boolean>> handler) {
    Future
      .<TxnResponse>future(txnFuture ->
        kvStub.txn(
          TxnRequest.newBuilder()
            .addCompare(Compare.newBuilder()
              .setKey(keyPath(k))
              .setTarget(Compare.CompareTarget.VALUE)
              .setResult(Compare.CompareResult.EQUAL)
              .setValue(toByteString(oldValue))
            )
            .addSuccess(RequestOp.newBuilder()
              .setRequestPut(PutRequest.newBuilder()
                .setKey(keyPath(k))
                .setValue(toByteString(newValue)))
            )
            .build(),
          txnFuture)
      )
      .map(txnResponse -> txnResponse.getSucceeded())
      .setHandler(handler);
  }

  @Override
  public void clear(Handler<AsyncResult<Void>> handler) {
    Future
      .<DeleteRangeResponse>future(clearFuture ->
        kvStub.deleteRange(
          DeleteRangeRequest.newBuilder()
            .setKey(rangeBegin)
            .setRangeEnd(rangeEnd)
            .build(),
          clearFuture)
      )
      .map((Void)null)
      .setHandler(handler);
  }

  @Override
  public void size(Handler<AsyncResult<Integer>> handler) {
    Future
      .<RangeResponse>future(clearFuture ->
        kvStub.range(
          RangeRequest.newBuilder()
            .setKey(rangeBegin)
            .setRangeEnd(rangeEnd)
            .build(),
          clearFuture)
      )
      .map(res -> res.getKvsCount())
      .setHandler(handler);
  }

  private ByteString keyPath(K key) {
    return rangeBegin.concat(toByteString(key));
  }

}
