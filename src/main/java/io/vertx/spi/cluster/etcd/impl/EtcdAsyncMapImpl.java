package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.Compare;
import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.DeleteRangeResponse;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.LeaseGrantRequest;
import com.coreos.jetcd.api.LeaseGrantResponse;
import com.coreos.jetcd.api.LeaseGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.RangeRequest;
import com.coreos.jetcd.api.RangeResponse;
import com.coreos.jetcd.api.RequestOp;
import com.coreos.jetcd.api.TxnRequest;
import com.coreos.jetcd.api.TxnResponse;

import io.grpc.ManagedChannel;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.shareddata.AsyncMap;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMapImpl<K, V> implements AsyncMap<K, V> {

  private Vertx vertx;

  private KVGrpc.KVBlockingStub kvStub;

  private LeaseGrpc.LeaseBlockingStub leaseStub;

  private String rangeBegin, rangeEnd;

  public EtcdAsyncMapImpl(String name, ManagedChannel channel, Vertx vertx) {
    this.vertx = vertx;
    this.kvStub = KVGrpc.newBlockingStub(channel);
    this.leaseStub = LeaseGrpc.newBlockingStub(channel);
    rangeBegin = name + "/";
    rangeEnd = name + "0"; // '0' is the next char of '/'
  }

  @Override
  public void get(K k, Handler<AsyncResult<V>> handler) {
    vertx.executeBlocking(future -> {
      RangeResponse res = kvStub.range(
        RangeRequest.newBuilder()
          .setKey(keyPath(k)).build());
      if (res.getKvsCount() == 0) {
        future.complete();
      } else {
        future.complete(
          fromByteString(res.getKvs(0).getValue())
        );
      }
    }, false, handler);
  }

  @Override
  public void put(K k, V v, Handler<AsyncResult<Void>> handler) {
    vertx.executeBlocking(future -> {
      kvStub.put(
        PutRequest.newBuilder()
          .setKey(keyPath(k))
          .setValue(toByteString(v))
          .build());
      future.complete();
    }, false, handler);
  }

  @Override
  public void put(K k, V v, long ttl, Handler<AsyncResult<Void>> handler) {
    vertx.executeBlocking(future -> {
      LeaseGrantResponse leaseRes = leaseStub.leaseGrant(LeaseGrantRequest.newBuilder()
        .setTTL(castToSeconds(ttl)) // cast ms to sec
        .build());
      kvStub.put(
        PutRequest.newBuilder()
          .setKey(keyPath(k))
          .setValue(toByteString(v))
          .setLease(leaseRes.getID())
          .build());
      future.complete();
    }, false, handler);
  }

  @Override
  public void putIfAbsent(K k, V v, Handler<AsyncResult<V>> handler) {
    vertx.executeBlocking(future -> {
      TxnResponse txnRes = kvStub.txn(
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
          .build());
      if (txnRes.getSucceeded()) {
        future.complete(null);
      } else {
        future.complete(
          fromByteString(txnRes.getResponses(0)
            .getResponseRange().getKvs(0).getValue())
        );
      }
    }, false, handler);
  }

  @Override
  public void putIfAbsent(K k, V v, long ttl, Handler<AsyncResult<V>> handler) {
    vertx.executeBlocking(future -> {
      LeaseGrantResponse leaseRes = leaseStub.leaseGrant(LeaseGrantRequest.newBuilder()
        .setTTL(castToSeconds(ttl)) // cast ms to sec
        .build());
      TxnResponse txnRes = kvStub.txn(
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
              .setValue(toByteString(v))
              .setLease(leaseRes.getID()))
          )
          .addFailure(RequestOp.newBuilder()
            .setRequestRange(RangeRequest.newBuilder()
              .setKey(keyPath(k)))
          )
          .build());
      if (txnRes.getSucceeded()) {
        future.complete(null);
      } else {
        future.complete(
          fromByteString(txnRes.getResponses(0)
            .getResponseRange().getKvs(0).getValue())
        );
      }
    }, false, handler);
  }

  @Override
  public void remove(K k, Handler<AsyncResult<V>> handler) {
    vertx.executeBlocking(future -> {
      DeleteRangeResponse deleteRes = kvStub.deleteRange(
        DeleteRangeRequest.newBuilder()
          .setKey(keyPath(k))
          .setPrevKv(true)
          .build());
      if (deleteRes.getPrevKvsCount() == 0) {
        future.complete();
      } else {
        future.complete(
          fromByteString(deleteRes.getPrevKvs(0).getValue())
        );
      }
    }, false, handler);
  }

  @Override
  public void removeIfPresent(K k, V v, Handler<AsyncResult<Boolean>> handler) {
    vertx.executeBlocking(future -> {
      TxnResponse txnRes = kvStub.txn(
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
          .build());
      future.complete(txnRes.getSucceeded());
    }, false, handler);
  }

  @Override
  public void replace(K k, V v, Handler<AsyncResult<V>> handler) {
    vertx.executeBlocking(future -> {
      TxnResponse txnRes = kvStub.txn(
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
          .build()
      );
      if (!txnRes.getSucceeded()) {
        future.complete();
      } else {
        future.complete(
          fromByteString(txnRes.getResponses(0)
            .getResponsePut().getPrevKv().getValue())
        );
      }
    }, false, handler);
  }

  @Override
  public void replaceIfPresent(K k, V oldValue, V newValue, Handler<AsyncResult<Boolean>> handler) {
    vertx.executeBlocking(future -> {
      TxnResponse txnRes = kvStub.txn(
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
          .build()
      );
      future.complete(txnRes.getSucceeded());
    }, false, handler);
  }

  @Override
  public void clear(Handler<AsyncResult<Void>> handler) {
    vertx.executeBlocking(future -> {
      kvStub.deleteRange(
        DeleteRangeRequest.newBuilder()
          .setKey(ByteString.copyFromUtf8(rangeBegin))
          .setRangeEnd(ByteString.copyFromUtf8(rangeEnd))
          .build());
      future.complete();
    }, false, handler);
  }

  @Override
  public void size(Handler<AsyncResult<Integer>> handler) {
    vertx.executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(
        RangeRequest.newBuilder()
          .setKey(ByteString.copyFromUtf8(rangeBegin))
          .setRangeEnd(ByteString.copyFromUtf8(rangeEnd))
          .build());
      future.complete(rangeRes.getKvsCount());
    }, false, handler);
  }

  private ByteString keyPath(K key) {
    return ByteString.copyFromUtf8(rangeBegin + key);
  }

  private long castToSeconds(long ttl) {
    //TODO missing accuracy
    return ttl / 1000 + ttl % 1000 == 0 ? 0 : 1;
  }

}
