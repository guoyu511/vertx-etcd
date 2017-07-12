package io.vertx.spi.cluster.etcd.impl;

import com.google.protobuf.ByteString;

import com.coreos.jetcd.api.Compare;
import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.Event;
import com.coreos.jetcd.api.KVGrpc;
import com.coreos.jetcd.api.PutRequest;
import com.coreos.jetcd.api.RequestOp;
import com.coreos.jetcd.api.TxnRequest;
import com.coreos.jetcd.api.TxnResponse;
import com.coreos.jetcd.api.WatchCancelRequest;
import com.coreos.jetcd.api.WatchCreateRequest;
import com.coreos.jetcd.api.WatchGrpc;
import com.coreos.jetcd.api.WatchRequest;
import com.coreos.jetcd.api.WatchResponse;

import io.grpc.ManagedChannel;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.VertxException;
import io.vertx.core.shareddata.Lock;
import io.vertx.grpc.GrpcBidiExchange;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class LockImpl implements Lock {

  private Vertx vertx;

  private ByteString key;

  private KVGrpc.KVVertxStub kvStub;

  private WatchGrpc.WatchVertxStub watchStub;

  private Handler<AsyncResult<Lock>> handler;

  private long timeoutTimer;

  private long timeout;

  private long sharedLease;

  private long watchId;

  private GrpcBidiExchange<WatchResponse, WatchRequest> watchExchange;

  public LockImpl(String name, long timeout, long sharedLease, ManagedChannel channel, Vertx vertx) {
    this.key = ByteString.copyFromUtf8(name);
    this.vertx = vertx;
    this.timeout = timeout;
    this.sharedLease = sharedLease;
    kvStub = KVGrpc.newVertxStub(channel);
    watchStub = WatchGrpc.newVertxStub(channel);
  }

  public void aquire(Handler<AsyncResult<Lock>> handler) {
    this.handler = handler;
    watchStub.watch(exchange -> {
      this.watchExchange = exchange;
      this.watchExchange.handler(this::handleWatchResponse);
      tryAquire();
    });
  }

  @Override
  public void release() {
    kvStub.deleteRange(
      DeleteRangeRequest.newBuilder()
        .setKey(key).build(),
      (ar) -> {});
  }

  private void tryAquire() {
    compareAndSet()
      .setHandler(ar -> {
        if (ar.result()) {
          handler.handle(Future.succeededFuture(this));
        }
        waitTimeout();
      });
  }

  private Future<Boolean> compareAndSet() {
    return Future.<TxnResponse>future(txnFuture ->
      kvStub.txn(
        TxnRequest.newBuilder()
          .addCompare(Compare.newBuilder()
            .setKey(key)
            .setTarget(Compare.CompareTarget.VERSION)
            .setResult(Compare.CompareResult.LESS)
            .setVersion(1)
          )
          .addSuccess(RequestOp.newBuilder()
            .setRequestPut(PutRequest.newBuilder()
              .setKey(key)
              .setValue(ByteString.EMPTY)
              .setLease(sharedLease))
          )
          .build(),
        txnFuture)
      )
      .map(TxnResponse::getSucceeded)
      .otherwise(false);
  }

  private void waitTimeout() {
    watchExchange.write(
      WatchRequest.newBuilder()
        .setCreateRequest(WatchCreateRequest.newBuilder().setKey(key))
        .build());
    //TODO reduce timeout
    timeoutTimer = vertx.setTimer(timeout, (ignore) -> timeout());
  }

  private void handleWatchResponse(WatchResponse response) {
    if (response.getCanceled()) {
      return;
    }
    if (response.getCreated()) {
      watchId = response.getWatchId();
      return;
    }
    if (response.getEvents(0).getType() != Event.EventType.DELETE) {
      return;
    }
    vertx.cancelTimer(timeoutTimer);
    tryAquire();
  }

  private void timeout() {
    watchExchange
      .write(WatchRequest.newBuilder()
        .setCancelRequest(
          WatchCancelRequest.newBuilder()
            .setWatchId(watchId)
        )
        .build());
    handler.handle(Future.failedFuture(
      new VertxException("Lock aquire timeout:" + key.toStringUtf8())));
  }

}
