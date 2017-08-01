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
import io.grpc.stub.StreamObserver;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.VertxException;
import io.vertx.core.impl.ContextImpl;
import io.vertx.core.impl.TaskQueue;
import io.vertx.core.shareddata.Lock;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class LockImpl implements Lock {

  private Vertx vertx;

  private ContextImpl context;

  private ByteString key;

  private KVGrpc.KVBlockingStub kvStub;

  private WatchGrpc.WatchStub watchStub;

  private Handler<AsyncResult<Lock>> handler;

  private TaskQueue taskQueue = new TaskQueue();

  private long timeoutTimer;

  private long timeout;

  private long sharedLease;

  private long watchId;

  private StreamObserver<WatchRequest> watcher;

  public LockImpl(String name, long timeout, long sharedLease, ManagedChannel channel, Vertx vertx) {
    this.key = ByteString.copyFromUtf8(name);
    this.vertx = vertx;
    this.context = (ContextImpl)vertx.getOrCreateContext();
    this.timeout = timeout;
    this.sharedLease = sharedLease;
    kvStub = KVGrpc.newBlockingStub(channel);
    watchStub = WatchGrpc.newStub(channel);
  }

  public void aquire(Handler<AsyncResult<Lock>> handler) {
    this.handler = handler;
    startTimeout();
    tryAquire();
  }

  @Override
  public void release() {
    context.executeBlocking(future ->
      kvStub.deleteRange(
        DeleteRangeRequest.newBuilder()
          .setKey(key).build())
    , taskQueue, (ar) -> {});
  }

  private void tryAquire() {
    context.<Boolean>executeBlocking(future -> {
      TxnResponse txnRes = kvStub.txn(
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
          .build());
      future.complete(txnRes.getSucceeded());
    }, taskQueue, (ar) -> {
      if (ar.failed()) {
        failImmediately(ar.cause());
      }
      if (ar.result()) {
        cancelTimeout();
        handler.handle(Future.succeededFuture(this));
      } else {
        startWatch();
      }
    });
  }

  private void startWatch() {
    context.<StreamObserver<WatchRequest>>executeBlocking(future -> {
      StreamObserver<WatchRequest> watcher = watchStub.watch(new Observer());
      watcher.onNext(
        WatchRequest.newBuilder()
          .setCreateRequest(WatchCreateRequest.newBuilder().setKey(key))
          .build());
      future.complete(watcher);
    }, taskQueue, ar -> {
      if (ar.failed()) {
        return;
      }
      watcher = ar.result();
    });
  }

  private void cancelWatch() {
    if (watcher == null) {
      return;
    }
    context.executeBlocking(future -> {
      watcher.onNext(WatchRequest.newBuilder()
        .setCancelRequest(
          WatchCancelRequest.newBuilder()
            .setWatchId(watchId)
        )
        .build());
      future.complete();
    }, taskQueue, ar -> watcher = null);
  }

  private void startTimeout() {
    timeoutTimer = vertx.setTimer(timeout,
      (ignore) -> triggerTimeout());
  }

  private void cancelTimeout() {
    if (timeoutTimer != -1) {
      vertx.cancelTimer(timeoutTimer);
    }
    timeoutTimer = -1;
  }

  private void triggerTimeout() {
    failImmediately(new VertxException("Lock aquire timeout:" + key.toStringUtf8()));
  }

  private void failImmediately(Throwable t) {
    cancelWatch();
    cancelTimeout();
    handler.handle(Future.failedFuture(t));
  }

  private class Observer implements StreamObserver<WatchResponse> {

    @Override
    public void onNext(WatchResponse watchRes) {
      context.runOnContext((ignore) -> {
        if (watchRes.getCanceled()) {
          return;
        }
        if (watchRes.getCreated()) {
          watchId = watchRes.getWatchId();
          return;
        }
        if (watchRes.getEvents(0).getType() != Event.EventType.DELETE) {
          return;
        }
        cancelWatch();
        tryAquire();
      });
    }

    @Override
    public void onError(Throwable t) {
      context.runOnContext(ignore -> failImmediately(t));
    }

    @Override
    public void onCompleted() {}

  }

}
