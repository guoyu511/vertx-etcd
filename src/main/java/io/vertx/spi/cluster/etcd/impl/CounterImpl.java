package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.Compare;
import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.RangeRequest;
import com.coreos.jetcd.api.RangeResponse;
import com.coreos.jetcd.api.RequestOp;
import com.coreos.jetcd.api.TxnRequest;
import com.coreos.jetcd.api.TxnResponse;

import java.util.Objects;

import io.grpc.ManagedChannel;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.shareddata.Counter;

import static io.vertx.spi.cluster.etcd.impl.Codec.fromByteString;
import static io.vertx.spi.cluster.etcd.impl.Codec.toByteString;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class CounterImpl implements Counter {

  private Vertx vertx;

  private ByteString key;

  private KVGrpc.KVBlockingStub kvStub;

  private long sharedLease;

  public CounterImpl(String name, long sharedLease, ManagedChannel channel, Vertx vertx) {
    this.vertx = vertx;
    kvStub = KVGrpc.newBlockingStub(channel);
    this.key = ByteString.copyFromUtf8(name);
    this.sharedLease = sharedLease;
  }

  @Override
  public void get(Handler<AsyncResult<Long>> resultHandler) {
    Objects.requireNonNull(resultHandler);
    vertx.executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(RangeRequest.newBuilder()
        .setKey(key)
        .build());
      if (rangeRes.getKvsCount() == 0) {
        future.complete(0l);
      } else {
        future.complete(
          fromByteString(rangeRes.getKvs(0).getValue())
        );
      }
    }, resultHandler);
  }

  @Override
  public void incrementAndGet(Handler<AsyncResult<Long>> resultHandler) {
    addAndGet(1, resultHandler);
  }

  @Override
  public void getAndIncrement(Handler<AsyncResult<Long>> resultHandler) {
    getAndAdd(1, resultHandler);
  }

  @Override
  public void decrementAndGet(Handler<AsyncResult<Long>> resultHandler) {
    addAndGet(-1, resultHandler);
  }

  @Override
  public void addAndGet(long value, Handler<AsyncResult<Long>> resultHandler) {
    Objects.requireNonNull(resultHandler);
    vertx.<Long>executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(RangeRequest.newBuilder()
        .setKey(key)
        .build());
      if (rangeRes.getKvsCount() == 0) {
        future.complete(0l);
      } else {
        future.complete(fromByteString(rangeRes.getKvs(0).getValue()));
      }
    }, (ar) -> {
      if (ar.failed()) {
        resultHandler.handle(Future.failedFuture(ar.cause()));
        return;
      }
      long expected = ar.result();
      long newValue = expected + value;
      compareAndSet(expected, newValue, (casRes) -> {
        if (casRes.failed()) {
          resultHandler.handle(Future.failedFuture(ar.cause()));
        } else if (casRes.result()) {
          resultHandler.handle(casRes.map(newValue));
        } else {
          getAndAdd(value, resultHandler);
        }
      });
    });
  }

  @Override
  public void getAndAdd(long value, Handler<AsyncResult<Long>> resultHandler) {
    Objects.requireNonNull(resultHandler);
    vertx.<Long>executeBlocking(future -> {
      RangeResponse rangeRes = kvStub.range(RangeRequest.newBuilder()
        .setKey(key)
        .build());
      if (rangeRes.getKvsCount() == 0) {
        future.complete(0l);
      } else {
        future.complete(fromByteString(rangeRes.getKvs(0).getValue()));
      }
    }, (ar) -> {
      if (ar.failed()) {
        resultHandler.handle(Future.failedFuture(ar.cause()));
        return;
      }
      long expected = ar.result();
      long newValue = expected + value;
      compareAndSet(expected, newValue, (casRes) -> {
        if (casRes.failed()) {
          resultHandler.handle(Future.failedFuture(ar.cause()));
        } else if (casRes.result()) {
          resultHandler.handle(casRes.map(expected));
        } else {
          getAndAdd(value, resultHandler);
        }
      });
    });
  }

  @Override
  public void compareAndSet(long expected, long value, Handler<AsyncResult<Boolean>> resultHandler) {
    Objects.requireNonNull(resultHandler);
    Compare.Builder compare = expected == 0 ?
      Compare.newBuilder()
        .setKey(key)
        .setTarget(Compare.CompareTarget.VERSION)
        .setResult(Compare.CompareResult.EQUAL)
        .setVersion(0) :
      Compare.newBuilder()
        .setKey(key)
        .setTarget(Compare.CompareTarget.VALUE)
        .setResult(Compare.CompareResult.EQUAL)
        .setValue(toByteString(expected));
    RequestOp.Builder successOp = RequestOp.newBuilder();
    if (value == 0) {
      successOp.setRequestDeleteRange(
        DeleteRangeRequest.newBuilder()
          .setKey(key)
          .build()
      );
    } else {
      successOp.setRequestPut(
        PutRequest.newBuilder()
          .setKey(key)
          .setValue(toByteString(value))
          .setLease(sharedLease)
          .setPrevKv(true)
          .build()
      );
    }
    vertx.executeBlocking(future -> {
      TxnResponse txnRes = kvStub.txn(
        TxnRequest.newBuilder()
          .addCompare(compare)
          .addSuccess(successOp)
          .addFailure(RequestOp.newBuilder()
            .setRequestRange(RangeRequest.newBuilder().setKey(key))
          )
          .build());
      future.complete(txnRes.getSucceeded());
    }, resultHandler);
  }

}
