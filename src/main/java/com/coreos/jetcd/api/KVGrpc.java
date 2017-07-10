package com.coreos.jetcd.api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: rpc.proto")
public final class KVGrpc {

  private KVGrpc() {}

  private static <T> io.grpc.stub.StreamObserver<T> toObserver(final io.vertx.core.Handler<io.vertx.core.AsyncResult<T>> handler) {
    return new io.grpc.stub.StreamObserver<T>() {
      private volatile boolean resolved = false;
      @Override
      public void onNext(T value) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture(value));
        }
      }

      @Override
      public void onError(Throwable t) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.failedFuture(t));
        }
      }

      @Override
      public void onCompleted() {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture());
        }
      }
    };
  }

  public static final String SERVICE_NAME = "etcdserverpb.KV";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.RangeRequest,
      com.coreos.jetcd.api.RangeResponse> METHOD_RANGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.KV", "Range"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.RangeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.RangeResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.PutRequest,
      com.coreos.jetcd.api.PutResponse> METHOD_PUT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.KV", "Put"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.PutRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.PutResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.DeleteRangeRequest,
      com.coreos.jetcd.api.DeleteRangeResponse> METHOD_DELETE_RANGE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.KV", "DeleteRange"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.DeleteRangeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.DeleteRangeResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.TxnRequest,
      com.coreos.jetcd.api.TxnResponse> METHOD_TXN =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.KV", "Txn"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.TxnRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.TxnResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.CompactionRequest,
      com.coreos.jetcd.api.CompactionResponse> METHOD_COMPACT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.KV", "Compact"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.CompactionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.CompactionResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KVStub newStub(io.grpc.Channel channel) {
    return new KVStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KVBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new KVBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static KVFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new KVFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static KVVertxStub newVertxStub(io.grpc.Channel channel) {
    return new KVVertxStub(channel);
  }

  /**
   */
  public static abstract class KVImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Range gets the keys in the range from the key-value store.
     * </pre>
     */
    public void range(com.coreos.jetcd.api.RangeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.RangeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RANGE, responseObserver);
    }

    /**
     * <pre>
     * Put puts the given key into the key-value store.
     * A put request increments the revision of the key-value store
     * and generates one event in the event history.
     * </pre>
     */
    public void put(com.coreos.jetcd.api.PutRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.PutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUT, responseObserver);
    }

    /**
     * <pre>
     * DeleteRange deletes the given range from the key-value store.
     * A delete request increments the revision of the key-value store
     * and generates a delete event in the event history for every deleted key.
     * </pre>
     */
    public void deleteRange(com.coreos.jetcd.api.DeleteRangeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DeleteRangeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_RANGE, responseObserver);
    }

    /**
     * <pre>
     * Txn processes multiple requests in a single transaction.
     * A txn request increments the revision of the key-value store
     * and generates events with the same revision for every completed request.
     * It is not allowed to modify the same key several times within one txn.
     * </pre>
     */
    public void txn(com.coreos.jetcd.api.TxnRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.TxnResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_TXN, responseObserver);
    }

    /**
     * <pre>
     * Compact compacts the event history in the etcd key-value store. The key-value
     * store should be periodically compacted or the event history will continue to grow
     * indefinitely.
     * </pre>
     */
    public void compact(com.coreos.jetcd.api.CompactionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.CompactionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_COMPACT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_RANGE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.RangeRequest,
                com.coreos.jetcd.api.RangeResponse>(
                  this, METHODID_RANGE)))
          .addMethod(
            METHOD_PUT,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.PutRequest,
                com.coreos.jetcd.api.PutResponse>(
                  this, METHODID_PUT)))
          .addMethod(
            METHOD_DELETE_RANGE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.DeleteRangeRequest,
                com.coreos.jetcd.api.DeleteRangeResponse>(
                  this, METHODID_DELETE_RANGE)))
          .addMethod(
            METHOD_TXN,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.TxnRequest,
                com.coreos.jetcd.api.TxnResponse>(
                  this, METHODID_TXN)))
          .addMethod(
            METHOD_COMPACT,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.CompactionRequest,
                com.coreos.jetcd.api.CompactionResponse>(
                  this, METHODID_COMPACT)))
          .build();
    }
  }

  /**
   */
  public static final class KVStub extends io.grpc.stub.AbstractStub<KVStub> {
    private KVStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KVStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KVStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KVStub(channel, callOptions);
    }

    /**
     * <pre>
     * Range gets the keys in the range from the key-value store.
     * </pre>
     */
    public void range(com.coreos.jetcd.api.RangeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.RangeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_RANGE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Put puts the given key into the key-value store.
     * A put request increments the revision of the key-value store
     * and generates one event in the event history.
     * </pre>
     */
    public void put(com.coreos.jetcd.api.PutRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.PutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * DeleteRange deletes the given range from the key-value store.
     * A delete request increments the revision of the key-value store
     * and generates a delete event in the event history for every deleted key.
     * </pre>
     */
    public void deleteRange(com.coreos.jetcd.api.DeleteRangeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DeleteRangeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_RANGE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Txn processes multiple requests in a single transaction.
     * A txn request increments the revision of the key-value store
     * and generates events with the same revision for every completed request.
     * It is not allowed to modify the same key several times within one txn.
     * </pre>
     */
    public void txn(com.coreos.jetcd.api.TxnRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.TxnResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_TXN, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Compact compacts the event history in the etcd key-value store. The key-value
     * store should be periodically compacted or the event history will continue to grow
     * indefinitely.
     * </pre>
     */
    public void compact(com.coreos.jetcd.api.CompactionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.CompactionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_COMPACT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KVBlockingStub extends io.grpc.stub.AbstractStub<KVBlockingStub> {
    private KVBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KVBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KVBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KVBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Range gets the keys in the range from the key-value store.
     * </pre>
     */
    public com.coreos.jetcd.api.RangeResponse range(com.coreos.jetcd.api.RangeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_RANGE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Put puts the given key into the key-value store.
     * A put request increments the revision of the key-value store
     * and generates one event in the event history.
     * </pre>
     */
    public com.coreos.jetcd.api.PutResponse put(com.coreos.jetcd.api.PutRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUT, getCallOptions(), request);
    }

    /**
     * <pre>
     * DeleteRange deletes the given range from the key-value store.
     * A delete request increments the revision of the key-value store
     * and generates a delete event in the event history for every deleted key.
     * </pre>
     */
    public com.coreos.jetcd.api.DeleteRangeResponse deleteRange(com.coreos.jetcd.api.DeleteRangeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE_RANGE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Txn processes multiple requests in a single transaction.
     * A txn request increments the revision of the key-value store
     * and generates events with the same revision for every completed request.
     * It is not allowed to modify the same key several times within one txn.
     * </pre>
     */
    public com.coreos.jetcd.api.TxnResponse txn(com.coreos.jetcd.api.TxnRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_TXN, getCallOptions(), request);
    }

    /**
     * <pre>
     * Compact compacts the event history in the etcd key-value store. The key-value
     * store should be periodically compacted or the event history will continue to grow
     * indefinitely.
     * </pre>
     */
    public com.coreos.jetcd.api.CompactionResponse compact(com.coreos.jetcd.api.CompactionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_COMPACT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KVFutureStub extends io.grpc.stub.AbstractStub<KVFutureStub> {
    private KVFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KVFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KVFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KVFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Range gets the keys in the range from the key-value store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.RangeResponse> range(
        com.coreos.jetcd.api.RangeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_RANGE, getCallOptions()), request);
    }

    /**
     * <pre>
     * Put puts the given key into the key-value store.
     * A put request increments the revision of the key-value store
     * and generates one event in the event history.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.PutResponse> put(
        com.coreos.jetcd.api.PutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUT, getCallOptions()), request);
    }

    /**
     * <pre>
     * DeleteRange deletes the given range from the key-value store.
     * A delete request increments the revision of the key-value store
     * and generates a delete event in the event history for every deleted key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.DeleteRangeResponse> deleteRange(
        com.coreos.jetcd.api.DeleteRangeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE_RANGE, getCallOptions()), request);
    }

    /**
     * <pre>
     * Txn processes multiple requests in a single transaction.
     * A txn request increments the revision of the key-value store
     * and generates events with the same revision for every completed request.
     * It is not allowed to modify the same key several times within one txn.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.TxnResponse> txn(
        com.coreos.jetcd.api.TxnRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_TXN, getCallOptions()), request);
    }

    /**
     * <pre>
     * Compact compacts the event history in the etcd key-value store. The key-value
     * store should be periodically compacted or the event history will continue to grow
     * indefinitely.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.CompactionResponse> compact(
        com.coreos.jetcd.api.CompactionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_COMPACT, getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class KVVertxImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Range gets the keys in the range from the key-value store.
     * </pre>
     */
    public void range(com.coreos.jetcd.api.RangeRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.RangeResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_RANGE, KVGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Put puts the given key into the key-value store.
     * A put request increments the revision of the key-value store
     * and generates one event in the event history.
     * </pre>
     */
    public void put(com.coreos.jetcd.api.PutRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.PutResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_PUT, KVGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * DeleteRange deletes the given range from the key-value store.
     * A delete request increments the revision of the key-value store
     * and generates a delete event in the event history for every deleted key.
     * </pre>
     */
    public void deleteRange(com.coreos.jetcd.api.DeleteRangeRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.DeleteRangeResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_DELETE_RANGE, KVGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Txn processes multiple requests in a single transaction.
     * A txn request increments the revision of the key-value store
     * and generates events with the same revision for every completed request.
     * It is not allowed to modify the same key several times within one txn.
     * </pre>
     */
    public void txn(com.coreos.jetcd.api.TxnRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.TxnResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_TXN, KVGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Compact compacts the event history in the etcd key-value store. The key-value
     * store should be periodically compacted or the event history will continue to grow
     * indefinitely.
     * </pre>
     */
    public void compact(com.coreos.jetcd.api.CompactionRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.CompactionResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_COMPACT, KVGrpc.toObserver(response.completer()));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_RANGE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.RangeRequest,
                com.coreos.jetcd.api.RangeResponse>(
                  this, METHODID_RANGE)))
          .addMethod(
            METHOD_PUT,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.PutRequest,
                com.coreos.jetcd.api.PutResponse>(
                  this, METHODID_PUT)))
          .addMethod(
            METHOD_DELETE_RANGE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.DeleteRangeRequest,
                com.coreos.jetcd.api.DeleteRangeResponse>(
                  this, METHODID_DELETE_RANGE)))
          .addMethod(
            METHOD_TXN,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.TxnRequest,
                com.coreos.jetcd.api.TxnResponse>(
                  this, METHODID_TXN)))
          .addMethod(
            METHOD_COMPACT,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.CompactionRequest,
                com.coreos.jetcd.api.CompactionResponse>(
                  this, METHODID_COMPACT)))
          .build();
    }
  }

  /**
   */
  public static final class KVVertxStub extends io.grpc.stub.AbstractStub<KVVertxStub> {
    private KVVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KVVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KVVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KVVertxStub(channel, callOptions);
    }

    /**
     * <pre>
     * Range gets the keys in the range from the key-value store.
     * </pre>
     */
    public void range(com.coreos.jetcd.api.RangeRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.RangeResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_RANGE, getCallOptions()), request, KVGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Put puts the given key into the key-value store.
     * A put request increments the revision of the key-value store
     * and generates one event in the event history.
     * </pre>
     */
    public void put(com.coreos.jetcd.api.PutRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.PutResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUT, getCallOptions()), request, KVGrpc.toObserver(response));
    }

    /**
     * <pre>
     * DeleteRange deletes the given range from the key-value store.
     * A delete request increments the revision of the key-value store
     * and generates a delete event in the event history for every deleted key.
     * </pre>
     */
    public void deleteRange(com.coreos.jetcd.api.DeleteRangeRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.DeleteRangeResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE_RANGE, getCallOptions()), request, KVGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Txn processes multiple requests in a single transaction.
     * A txn request increments the revision of the key-value store
     * and generates events with the same revision for every completed request.
     * It is not allowed to modify the same key several times within one txn.
     * </pre>
     */
    public void txn(com.coreos.jetcd.api.TxnRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.TxnResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_TXN, getCallOptions()), request, KVGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Compact compacts the event history in the etcd key-value store. The key-value
     * store should be periodically compacted or the event history will continue to grow
     * indefinitely.
     * </pre>
     */
    public void compact(com.coreos.jetcd.api.CompactionRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.CompactionResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_COMPACT, getCallOptions()), request, KVGrpc.toObserver(response));
    }
  }

  private static final int METHODID_RANGE = 0;
  private static final int METHODID_PUT = 1;
  private static final int METHODID_DELETE_RANGE = 2;
  private static final int METHODID_TXN = 3;
  private static final int METHODID_COMPACT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KVImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KVImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RANGE:
          serviceImpl.range((com.coreos.jetcd.api.RangeRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.RangeResponse>) responseObserver);
          break;
        case METHODID_PUT:
          serviceImpl.put((com.coreos.jetcd.api.PutRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.PutResponse>) responseObserver);
          break;
        case METHODID_DELETE_RANGE:
          serviceImpl.deleteRange((com.coreos.jetcd.api.DeleteRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DeleteRangeResponse>) responseObserver);
          break;
        case METHODID_TXN:
          serviceImpl.txn((com.coreos.jetcd.api.TxnRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.TxnResponse>) responseObserver);
          break;
        case METHODID_COMPACT:
          serviceImpl.compact((com.coreos.jetcd.api.CompactionRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.CompactionResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class VertxMethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KVVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(KVVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RANGE:
          serviceImpl.range((com.coreos.jetcd.api.RangeRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.RangeResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.RangeResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.RangeResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_PUT:
          serviceImpl.put((com.coreos.jetcd.api.PutRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.PutResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.PutResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.PutResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_DELETE_RANGE:
          serviceImpl.deleteRange((com.coreos.jetcd.api.DeleteRangeRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.DeleteRangeResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.DeleteRangeResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DeleteRangeResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_TXN:
          serviceImpl.txn((com.coreos.jetcd.api.TxnRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.TxnResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.TxnResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.TxnResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_COMPACT:
          serviceImpl.compact((com.coreos.jetcd.api.CompactionRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.CompactionResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.CompactionResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.CompactionResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class KVDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.coreos.jetcd.api.JetcdProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (KVGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KVDescriptorSupplier())
              .addMethod(METHOD_RANGE)
              .addMethod(METHOD_PUT)
              .addMethod(METHOD_DELETE_RANGE)
              .addMethod(METHOD_TXN)
              .addMethod(METHOD_COMPACT)
              .build();
        }
      }
    }
    return result;
  }
}
