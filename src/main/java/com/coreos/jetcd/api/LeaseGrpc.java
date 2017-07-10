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
public final class LeaseGrpc {

  private LeaseGrpc() {}

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

  public static final String SERVICE_NAME = "etcdserverpb.Lease";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.LeaseGrantRequest,
      com.coreos.jetcd.api.LeaseGrantResponse> METHOD_LEASE_GRANT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseGrant"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseGrantRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseGrantResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.LeaseRevokeRequest,
      com.coreos.jetcd.api.LeaseRevokeResponse> METHOD_LEASE_REVOKE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseRevoke"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseRevokeRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseRevokeResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.LeaseKeepAliveRequest,
      com.coreos.jetcd.api.LeaseKeepAliveResponse> METHOD_LEASE_KEEP_ALIVE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseKeepAlive"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseKeepAliveRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseKeepAliveResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.LeaseTimeToLiveRequest,
      com.coreos.jetcd.api.LeaseTimeToLiveResponse> METHOD_LEASE_TIME_TO_LIVE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Lease", "LeaseTimeToLive"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseTimeToLiveRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.LeaseTimeToLiveResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LeaseStub newStub(io.grpc.Channel channel) {
    return new LeaseStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LeaseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LeaseBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static LeaseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LeaseFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static LeaseVertxStub newVertxStub(io.grpc.Channel channel) {
    return new LeaseVertxStub(channel);
  }

  /**
   */
  public static abstract class LeaseImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public void leaseGrant(com.coreos.jetcd.api.LeaseGrantRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseGrantResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_GRANT, responseObserver);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public void leaseRevoke(com.coreos.jetcd.api.LeaseRevokeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseRevokeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_REVOKE, responseObserver);
    }

    /**
     * <pre>
     * LeaseKeepAlive keeps the lease alive by streaming keep alive requests from the client
     * to the server and streaming keep alive responses from the server to the client.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseKeepAliveRequest> leaseKeepAlive(
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseKeepAliveResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_LEASE_KEEP_ALIVE, responseObserver);
    }

    /**
     * <pre>
     * LeaseTimeToLive retrieves lease information.
     * </pre>
     */
    public void leaseTimeToLive(com.coreos.jetcd.api.LeaseTimeToLiveRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseTimeToLiveResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_TIME_TO_LIVE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LEASE_GRANT,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.LeaseGrantRequest,
                com.coreos.jetcd.api.LeaseGrantResponse>(
                  this, METHODID_LEASE_GRANT)))
          .addMethod(
            METHOD_LEASE_REVOKE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.LeaseRevokeRequest,
                com.coreos.jetcd.api.LeaseRevokeResponse>(
                  this, METHODID_LEASE_REVOKE)))
          .addMethod(
            METHOD_LEASE_KEEP_ALIVE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.coreos.jetcd.api.LeaseKeepAliveRequest,
                com.coreos.jetcd.api.LeaseKeepAliveResponse>(
                  this, METHODID_LEASE_KEEP_ALIVE)))
          .addMethod(
            METHOD_LEASE_TIME_TO_LIVE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.LeaseTimeToLiveRequest,
                com.coreos.jetcd.api.LeaseTimeToLiveResponse>(
                  this, METHODID_LEASE_TIME_TO_LIVE)))
          .build();
    }
  }

  /**
   */
  public static final class LeaseStub extends io.grpc.stub.AbstractStub<LeaseStub> {
    private LeaseStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public void leaseGrant(com.coreos.jetcd.api.LeaseGrantRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseGrantResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_GRANT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public void leaseRevoke(com.coreos.jetcd.api.LeaseRevokeRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseRevokeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_REVOKE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * LeaseKeepAlive keeps the lease alive by streaming keep alive requests from the client
     * to the server and streaming keep alive responses from the server to the client.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseKeepAliveRequest> leaseKeepAlive(
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseKeepAliveResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_LEASE_KEEP_ALIVE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * LeaseTimeToLive retrieves lease information.
     * </pre>
     */
    public void leaseTimeToLive(com.coreos.jetcd.api.LeaseTimeToLiveRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseTimeToLiveResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_TIME_TO_LIVE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LeaseBlockingStub extends io.grpc.stub.AbstractStub<LeaseBlockingStub> {
    private LeaseBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public com.coreos.jetcd.api.LeaseGrantResponse leaseGrant(com.coreos.jetcd.api.LeaseGrantRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LEASE_GRANT, getCallOptions(), request);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public com.coreos.jetcd.api.LeaseRevokeResponse leaseRevoke(com.coreos.jetcd.api.LeaseRevokeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LEASE_REVOKE, getCallOptions(), request);
    }

    /**
     * <pre>
     * LeaseTimeToLive retrieves lease information.
     * </pre>
     */
    public com.coreos.jetcd.api.LeaseTimeToLiveResponse leaseTimeToLive(com.coreos.jetcd.api.LeaseTimeToLiveRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_LEASE_TIME_TO_LIVE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LeaseFutureStub extends io.grpc.stub.AbstractStub<LeaseFutureStub> {
    private LeaseFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.LeaseGrantResponse> leaseGrant(
        com.coreos.jetcd.api.LeaseGrantRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LEASE_GRANT, getCallOptions()), request);
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.LeaseRevokeResponse> leaseRevoke(
        com.coreos.jetcd.api.LeaseRevokeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LEASE_REVOKE, getCallOptions()), request);
    }

    /**
     * <pre>
     * LeaseTimeToLive retrieves lease information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.LeaseTimeToLiveResponse> leaseTimeToLive(
        com.coreos.jetcd.api.LeaseTimeToLiveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_LEASE_TIME_TO_LIVE, getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class LeaseVertxImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public void leaseGrant(com.coreos.jetcd.api.LeaseGrantRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.LeaseGrantResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_GRANT, LeaseGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public void leaseRevoke(com.coreos.jetcd.api.LeaseRevokeRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.LeaseRevokeResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_REVOKE, LeaseGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * LeaseKeepAlive keeps the lease alive by streaming keep alive requests from the client
     * to the server and streaming keep alive responses from the server to the client.
     * </pre>
     */
    public void leaseKeepAlive(
        io.vertx.grpc.GrpcBidiExchange<com.coreos.jetcd.api.LeaseKeepAliveRequest, com.coreos.jetcd.api.LeaseKeepAliveResponse> exchange) {
      exchange.setReadObserver(asyncUnimplementedStreamingCall(METHOD_LEASE_KEEP_ALIVE, exchange.writeObserver()));
    }

    /**
     * <pre>
     * LeaseTimeToLive retrieves lease information.
     * </pre>
     */
    public void leaseTimeToLive(com.coreos.jetcd.api.LeaseTimeToLiveRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.LeaseTimeToLiveResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_LEASE_TIME_TO_LIVE, LeaseGrpc.toObserver(response.completer()));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_LEASE_GRANT,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.LeaseGrantRequest,
                com.coreos.jetcd.api.LeaseGrantResponse>(
                  this, METHODID_LEASE_GRANT)))
          .addMethod(
            METHOD_LEASE_REVOKE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.LeaseRevokeRequest,
                com.coreos.jetcd.api.LeaseRevokeResponse>(
                  this, METHODID_LEASE_REVOKE)))
          .addMethod(
            METHOD_LEASE_KEEP_ALIVE,
            asyncBidiStreamingCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.LeaseKeepAliveRequest,
                com.coreos.jetcd.api.LeaseKeepAliveResponse>(
                  this, METHODID_LEASE_KEEP_ALIVE)))
          .addMethod(
            METHOD_LEASE_TIME_TO_LIVE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.LeaseTimeToLiveRequest,
                com.coreos.jetcd.api.LeaseTimeToLiveResponse>(
                  this, METHODID_LEASE_TIME_TO_LIVE)))
          .build();
    }
  }

  /**
   */
  public static final class LeaseVertxStub extends io.grpc.stub.AbstractStub<LeaseVertxStub> {
    private LeaseVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LeaseVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LeaseVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LeaseVertxStub(channel, callOptions);
    }

    /**
     * <pre>
     * LeaseGrant creates a lease which expires if the server does not receive a keepAlive
     * within a given time to live period. All keys attached to the lease will be expired and
     * deleted if the lease expires. Each expired key generates a delete event in the event history.
     * </pre>
     */
    public void leaseGrant(com.coreos.jetcd.api.LeaseGrantRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.LeaseGrantResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_GRANT, getCallOptions()), request, LeaseGrpc.toObserver(response));
    }

    /**
     * <pre>
     * LeaseRevoke revokes a lease. All keys attached to the lease will expire and be deleted.
     * </pre>
     */
    public void leaseRevoke(com.coreos.jetcd.api.LeaseRevokeRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.LeaseRevokeResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_REVOKE, getCallOptions()), request, LeaseGrpc.toObserver(response));
    }

    /**
     * <pre>
     * LeaseKeepAlive keeps the lease alive by streaming keep alive requests from the client
     * to the server and streaming keep alive responses from the server to the client.
     * </pre>
     */
    public void leaseKeepAlive(io.vertx.core.Handler<
        io.vertx.grpc.GrpcBidiExchange<com.coreos.jetcd.api.LeaseKeepAliveResponse, com.coreos.jetcd.api.LeaseKeepAliveRequest>> handler) {
      final io.vertx.grpc.GrpcReadStream<com.coreos.jetcd.api.LeaseKeepAliveResponse> readStream =
          io.vertx.grpc.GrpcReadStream.<com.coreos.jetcd.api.LeaseKeepAliveResponse>create();

      handler.handle(io.vertx.grpc.GrpcBidiExchange.create(readStream, asyncBidiStreamingCall(
          getChannel().newCall(METHOD_LEASE_KEEP_ALIVE, getCallOptions()), readStream.readObserver())));
    }

    /**
     * <pre>
     * LeaseTimeToLive retrieves lease information.
     * </pre>
     */
    public void leaseTimeToLive(com.coreos.jetcd.api.LeaseTimeToLiveRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.LeaseTimeToLiveResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_LEASE_TIME_TO_LIVE, getCallOptions()), request, LeaseGrpc.toObserver(response));
    }
  }

  private static final int METHODID_LEASE_GRANT = 0;
  private static final int METHODID_LEASE_REVOKE = 1;
  private static final int METHODID_LEASE_TIME_TO_LIVE = 2;
  private static final int METHODID_LEASE_KEEP_ALIVE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LeaseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LeaseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LEASE_GRANT:
          serviceImpl.leaseGrant((com.coreos.jetcd.api.LeaseGrantRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseGrantResponse>) responseObserver);
          break;
        case METHODID_LEASE_REVOKE:
          serviceImpl.leaseRevoke((com.coreos.jetcd.api.LeaseRevokeRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseRevokeResponse>) responseObserver);
          break;
        case METHODID_LEASE_TIME_TO_LIVE:
          serviceImpl.leaseTimeToLive((com.coreos.jetcd.api.LeaseTimeToLiveRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseTimeToLiveResponse>) responseObserver);
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
        case METHODID_LEASE_KEEP_ALIVE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.leaseKeepAlive(
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseKeepAliveResponse>) responseObserver);
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
    private final LeaseVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(LeaseVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LEASE_GRANT:
          serviceImpl.leaseGrant((com.coreos.jetcd.api.LeaseGrantRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.LeaseGrantResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.LeaseGrantResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseGrantResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_LEASE_REVOKE:
          serviceImpl.leaseRevoke((com.coreos.jetcd.api.LeaseRevokeRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.LeaseRevokeResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.LeaseRevokeResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseRevokeResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_LEASE_TIME_TO_LIVE:
          serviceImpl.leaseTimeToLive((com.coreos.jetcd.api.LeaseTimeToLiveRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.LeaseTimeToLiveResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.LeaseTimeToLiveResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseTimeToLiveResponse>) responseObserver).onNext(ar.result());
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
        case METHODID_LEASE_KEEP_ALIVE:
          io.vertx.grpc.GrpcReadStream<com.coreos.jetcd.api.LeaseKeepAliveRequest> request2 = io.vertx.grpc.GrpcReadStream.<com.coreos.jetcd.api.LeaseKeepAliveRequest>create();
          serviceImpl.leaseKeepAlive(
             io.vertx.grpc.GrpcBidiExchange.<com.coreos.jetcd.api.LeaseKeepAliveRequest, com.coreos.jetcd.api.LeaseKeepAliveResponse>create(
               request2,
               (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.LeaseKeepAliveResponse>) responseObserver));
          return (io.grpc.stub.StreamObserver<Req>) request2.readObserver();
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class LeaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.coreos.jetcd.api.JetcdProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LeaseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LeaseDescriptorSupplier())
              .addMethod(METHOD_LEASE_GRANT)
              .addMethod(METHOD_LEASE_REVOKE)
              .addMethod(METHOD_LEASE_KEEP_ALIVE)
              .addMethod(METHOD_LEASE_TIME_TO_LIVE)
              .build();
        }
      }
    }
    return result;
  }
}
