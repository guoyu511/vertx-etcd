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
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: rpc.proto")
public final class WatchGrpc {

  private WatchGrpc() {}

  public static final String SERVICE_NAME = "etcdserverpb.Watch";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.WatchRequest,
      com.coreos.jetcd.api.WatchResponse> METHOD_WATCH =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.WatchRequest, com.coreos.jetcd.api.WatchResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Watch", "Watch"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.WatchRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.WatchResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WatchStub newStub(io.grpc.Channel channel) {
    return new WatchStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WatchBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WatchBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WatchFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WatchFutureStub(channel);
  }

  /**
   */
  public static abstract class WatchImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Watch watches for events happening or that have happened. Both input and output
     * are streams; the input stream is for creating and canceling watchers and the output
     * stream sends events. One watch RPC can watch on multiple key ranges, streaming events
     * for several watches at once. The entire event history can be watched starting from the
     * last compaction revision.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.coreos.jetcd.api.WatchRequest> watch(
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.WatchResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_WATCH, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_WATCH,
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.coreos.jetcd.api.WatchRequest,
                com.coreos.jetcd.api.WatchResponse>(
                  this, METHODID_WATCH)))
          .build();
    }
  }

  /**
   */
  public static final class WatchStub extends io.grpc.stub.AbstractStub<WatchStub> {
    private WatchStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WatchStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WatchStub(channel, callOptions);
    }

    /**
     * <pre>
     * Watch watches for events happening or that have happened. Both input and output
     * are streams; the input stream is for creating and canceling watchers and the output
     * stream sends events. One watch RPC can watch on multiple key ranges, streaming events
     * for several watches at once. The entire event history can be watched starting from the
     * last compaction revision.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.coreos.jetcd.api.WatchRequest> watch(
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.WatchResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_WATCH, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class WatchBlockingStub extends io.grpc.stub.AbstractStub<WatchBlockingStub> {
    private WatchBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WatchBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WatchBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class WatchFutureStub extends io.grpc.stub.AbstractStub<WatchFutureStub> {
    private WatchFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WatchFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WatchFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WatchFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_WATCH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WatchImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WatchImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WATCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.watch(
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.WatchResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class WatchDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.coreos.jetcd.api.JetcdProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WatchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WatchDescriptorSupplier())
              .addMethod(METHOD_WATCH)
              .build();
        }
      }
    }
    return result;
  }
}
