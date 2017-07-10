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
public final class MaintenanceGrpc {

  private MaintenanceGrpc() {}

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

  public static final String SERVICE_NAME = "etcdserverpb.Maintenance";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AlarmRequest,
      com.coreos.jetcd.api.AlarmResponse> METHOD_ALARM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Alarm"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AlarmRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AlarmResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.StatusRequest,
      com.coreos.jetcd.api.StatusResponse> METHOD_STATUS =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Status"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.StatusRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.StatusResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.DefragmentRequest,
      com.coreos.jetcd.api.DefragmentResponse> METHOD_DEFRAGMENT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Defragment"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.DefragmentRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.DefragmentResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.HashRequest,
      com.coreos.jetcd.api.HashResponse> METHOD_HASH =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Hash"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.HashRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.HashResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.SnapshotRequest,
      com.coreos.jetcd.api.SnapshotResponse> METHOD_SNAPSHOT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "etcdserverpb.Maintenance", "Snapshot"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.SnapshotRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.SnapshotResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MaintenanceStub newStub(io.grpc.Channel channel) {
    return new MaintenanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MaintenanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MaintenanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static MaintenanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MaintenanceFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static MaintenanceVertxStub newVertxStub(io.grpc.Channel channel) {
    return new MaintenanceVertxStub(channel);
  }

  /**
   */
  public static abstract class MaintenanceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public void alarm(com.coreos.jetcd.api.AlarmRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AlarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ALARM, responseObserver);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public void status(com.coreos.jetcd.api.StatusRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.StatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_STATUS, responseObserver);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public void defragment(com.coreos.jetcd.api.DefragmentRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DefragmentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DEFRAGMENT, responseObserver);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public void hash(com.coreos.jetcd.api.HashRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.HashResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_HASH, responseObserver);
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public void snapshot(com.coreos.jetcd.api.SnapshotRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.SnapshotResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SNAPSHOT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ALARM,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AlarmRequest,
                com.coreos.jetcd.api.AlarmResponse>(
                  this, METHODID_ALARM)))
          .addMethod(
            METHOD_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.StatusRequest,
                com.coreos.jetcd.api.StatusResponse>(
                  this, METHODID_STATUS)))
          .addMethod(
            METHOD_DEFRAGMENT,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.DefragmentRequest,
                com.coreos.jetcd.api.DefragmentResponse>(
                  this, METHODID_DEFRAGMENT)))
          .addMethod(
            METHOD_HASH,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.HashRequest,
                com.coreos.jetcd.api.HashResponse>(
                  this, METHODID_HASH)))
          .addMethod(
            METHOD_SNAPSHOT,
            asyncServerStreamingCall(
              new MethodHandlers<
                com.coreos.jetcd.api.SnapshotRequest,
                com.coreos.jetcd.api.SnapshotResponse>(
                  this, METHODID_SNAPSHOT)))
          .build();
    }
  }

  /**
   */
  public static final class MaintenanceStub extends io.grpc.stub.AbstractStub<MaintenanceStub> {
    private MaintenanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public void alarm(com.coreos.jetcd.api.AlarmRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AlarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ALARM, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public void status(com.coreos.jetcd.api.StatusRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.StatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public void defragment(com.coreos.jetcd.api.DefragmentRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DefragmentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DEFRAGMENT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public void hash(com.coreos.jetcd.api.HashRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.HashResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_HASH, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public void snapshot(com.coreos.jetcd.api.SnapshotRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.SnapshotResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SNAPSHOT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MaintenanceBlockingStub extends io.grpc.stub.AbstractStub<MaintenanceBlockingStub> {
    private MaintenanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public com.coreos.jetcd.api.AlarmResponse alarm(com.coreos.jetcd.api.AlarmRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ALARM, getCallOptions(), request);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public com.coreos.jetcd.api.StatusResponse status(com.coreos.jetcd.api.StatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_STATUS, getCallOptions(), request);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public com.coreos.jetcd.api.DefragmentResponse defragment(com.coreos.jetcd.api.DefragmentRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DEFRAGMENT, getCallOptions(), request);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public com.coreos.jetcd.api.HashResponse hash(com.coreos.jetcd.api.HashRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_HASH, getCallOptions(), request);
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public java.util.Iterator<com.coreos.jetcd.api.SnapshotResponse> snapshot(
        com.coreos.jetcd.api.SnapshotRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SNAPSHOT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MaintenanceFutureStub extends io.grpc.stub.AbstractStub<MaintenanceFutureStub> {
    private MaintenanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AlarmResponse> alarm(
        com.coreos.jetcd.api.AlarmRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ALARM, getCallOptions()), request);
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.StatusResponse> status(
        com.coreos.jetcd.api.StatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request);
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.DefragmentResponse> defragment(
        com.coreos.jetcd.api.DefragmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DEFRAGMENT, getCallOptions()), request);
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.HashResponse> hash(
        com.coreos.jetcd.api.HashRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_HASH, getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class MaintenanceVertxImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public void alarm(com.coreos.jetcd.api.AlarmRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AlarmResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ALARM, MaintenanceGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public void status(com.coreos.jetcd.api.StatusRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.StatusResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_STATUS, MaintenanceGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public void defragment(com.coreos.jetcd.api.DefragmentRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.DefragmentResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_DEFRAGMENT, MaintenanceGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public void hash(com.coreos.jetcd.api.HashRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.HashResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_HASH, MaintenanceGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public void snapshot(com.coreos.jetcd.api.SnapshotRequest request,
        io.vertx.grpc.GrpcWriteStream<com.coreos.jetcd.api.SnapshotResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_SNAPSHOT, response.writeObserver());
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ALARM,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AlarmRequest,
                com.coreos.jetcd.api.AlarmResponse>(
                  this, METHODID_ALARM)))
          .addMethod(
            METHOD_STATUS,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.StatusRequest,
                com.coreos.jetcd.api.StatusResponse>(
                  this, METHODID_STATUS)))
          .addMethod(
            METHOD_DEFRAGMENT,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.DefragmentRequest,
                com.coreos.jetcd.api.DefragmentResponse>(
                  this, METHODID_DEFRAGMENT)))
          .addMethod(
            METHOD_HASH,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.HashRequest,
                com.coreos.jetcd.api.HashResponse>(
                  this, METHODID_HASH)))
          .addMethod(
            METHOD_SNAPSHOT,
            asyncServerStreamingCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.SnapshotRequest,
                com.coreos.jetcd.api.SnapshotResponse>(
                  this, METHODID_SNAPSHOT)))
          .build();
    }
  }

  /**
   */
  public static final class MaintenanceVertxStub extends io.grpc.stub.AbstractStub<MaintenanceVertxStub> {
    private MaintenanceVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaintenanceVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaintenanceVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaintenanceVertxStub(channel, callOptions);
    }

    /**
     * <pre>
     * Alarm activates, deactivates, and queries alarms regarding cluster health.
     * </pre>
     */
    public void alarm(com.coreos.jetcd.api.AlarmRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AlarmResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ALARM, getCallOptions()), request, MaintenanceGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Status gets the status of the member.
     * </pre>
     */
    public void status(com.coreos.jetcd.api.StatusRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.StatusResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_STATUS, getCallOptions()), request, MaintenanceGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Defragment defragments a member's backend database to recover storage space.
     * </pre>
     */
    public void defragment(com.coreos.jetcd.api.DefragmentRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.DefragmentResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DEFRAGMENT, getCallOptions()), request, MaintenanceGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Hash returns the hash of the local KV state for consistency checking purpose.
     * This is designed for testing; do not use this in production when there
     * are ongoing transactions.
     * </pre>
     */
    public void hash(com.coreos.jetcd.api.HashRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.HashResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_HASH, getCallOptions()), request, MaintenanceGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Snapshot sends a snapshot of the entire backend from a member over a stream to a client.
     * </pre>
     */
    public void snapshot(com.coreos.jetcd.api.SnapshotRequest request,
        io.vertx.core.Handler<io.vertx.grpc.GrpcReadStream<com.coreos.jetcd.api.SnapshotResponse>> handler) {
      final io.vertx.grpc.GrpcReadStream<com.coreos.jetcd.api.SnapshotResponse> readStream =
          io.vertx.grpc.GrpcReadStream.<com.coreos.jetcd.api.SnapshotResponse>create();

      handler.handle(readStream);
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SNAPSHOT, getCallOptions()), request, readStream.readObserver());
    }
  }

  private static final int METHODID_ALARM = 0;
  private static final int METHODID_STATUS = 1;
  private static final int METHODID_DEFRAGMENT = 2;
  private static final int METHODID_HASH = 3;
  private static final int METHODID_SNAPSHOT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MaintenanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MaintenanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALARM:
          serviceImpl.alarm((com.coreos.jetcd.api.AlarmRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AlarmResponse>) responseObserver);
          break;
        case METHODID_STATUS:
          serviceImpl.status((com.coreos.jetcd.api.StatusRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.StatusResponse>) responseObserver);
          break;
        case METHODID_DEFRAGMENT:
          serviceImpl.defragment((com.coreos.jetcd.api.DefragmentRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DefragmentResponse>) responseObserver);
          break;
        case METHODID_HASH:
          serviceImpl.hash((com.coreos.jetcd.api.HashRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.HashResponse>) responseObserver);
          break;
        case METHODID_SNAPSHOT:
          serviceImpl.snapshot((com.coreos.jetcd.api.SnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.SnapshotResponse>) responseObserver);
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
    private final MaintenanceVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(MaintenanceVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ALARM:
          serviceImpl.alarm((com.coreos.jetcd.api.AlarmRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AlarmResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AlarmResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AlarmResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_STATUS:
          serviceImpl.status((com.coreos.jetcd.api.StatusRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.StatusResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.StatusResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.StatusResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_DEFRAGMENT:
          serviceImpl.defragment((com.coreos.jetcd.api.DefragmentRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.DefragmentResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.DefragmentResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.DefragmentResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_HASH:
          serviceImpl.hash((com.coreos.jetcd.api.HashRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.HashResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.HashResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.HashResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_SNAPSHOT:
          serviceImpl.snapshot((com.coreos.jetcd.api.SnapshotRequest) request,
              (io.vertx.grpc.GrpcWriteStream<com.coreos.jetcd.api.SnapshotResponse>) io.vertx.grpc.GrpcWriteStream.create(responseObserver));
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

  private static final class MaintenanceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.coreos.jetcd.api.JetcdProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MaintenanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MaintenanceDescriptorSupplier())
              .addMethod(METHOD_ALARM)
              .addMethod(METHOD_STATUS)
              .addMethod(METHOD_DEFRAGMENT)
              .addMethod(METHOD_HASH)
              .addMethod(METHOD_SNAPSHOT)
              .build();
        }
      }
    }
    return result;
  }
}
