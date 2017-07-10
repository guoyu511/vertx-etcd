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
public final class AuthGrpc {

  private AuthGrpc() {}

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

  public static final String SERVICE_NAME = "etcdserverpb.Auth";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthEnableRequest,
      com.coreos.jetcd.api.AuthEnableResponse> METHOD_AUTH_ENABLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "AuthEnable"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthEnableRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthEnableResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthDisableRequest,
      com.coreos.jetcd.api.AuthDisableResponse> METHOD_AUTH_DISABLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "AuthDisable"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthDisableRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthDisableResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthenticateRequest,
      com.coreos.jetcd.api.AuthenticateResponse> METHOD_AUTHENTICATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "Authenticate"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthenticateRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthenticateResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserAddRequest,
      com.coreos.jetcd.api.AuthUserAddResponse> METHOD_USER_ADD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserAdd"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserAddRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserAddResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserGetRequest,
      com.coreos.jetcd.api.AuthUserGetResponse> METHOD_USER_GET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserGet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserGetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserGetResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserListRequest,
      com.coreos.jetcd.api.AuthUserListResponse> METHOD_USER_LIST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserList"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserListRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserListResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserDeleteRequest,
      com.coreos.jetcd.api.AuthUserDeleteResponse> METHOD_USER_DELETE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserDelete"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserDeleteRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserDeleteResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserChangePasswordRequest,
      com.coreos.jetcd.api.AuthUserChangePasswordResponse> METHOD_USER_CHANGE_PASSWORD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserChangePassword"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserChangePasswordRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserChangePasswordResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserGrantRoleRequest,
      com.coreos.jetcd.api.AuthUserGrantRoleResponse> METHOD_USER_GRANT_ROLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserGrantRole"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserGrantRoleRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserGrantRoleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserRevokeRoleRequest,
      com.coreos.jetcd.api.AuthUserRevokeRoleResponse> METHOD_USER_REVOKE_ROLE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "UserRevokeRole"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserRevokeRoleRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthUserRevokeRoleResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleAddRequest,
      com.coreos.jetcd.api.AuthRoleAddResponse> METHOD_ROLE_ADD =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleAdd"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleAddRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleAddResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleGetRequest,
      com.coreos.jetcd.api.AuthRoleGetResponse> METHOD_ROLE_GET =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleGet"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleGetRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleGetResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleListRequest,
      com.coreos.jetcd.api.AuthRoleListResponse> METHOD_ROLE_LIST =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleList"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleListRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleListResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleDeleteRequest,
      com.coreos.jetcd.api.AuthRoleDeleteResponse> METHOD_ROLE_DELETE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleDelete"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleDeleteRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleDeleteResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleGrantPermissionRequest,
      com.coreos.jetcd.api.AuthRoleGrantPermissionResponse> METHOD_ROLE_GRANT_PERMISSION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleGrantPermission"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleGrantPermissionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleGrantPermissionResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleRevokePermissionRequest,
      com.coreos.jetcd.api.AuthRoleRevokePermissionResponse> METHOD_ROLE_REVOKE_PERMISSION =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "etcdserverpb.Auth", "RoleRevokePermission"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleRevokePermissionRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.coreos.jetcd.api.AuthRoleRevokePermissionResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthStub newStub(io.grpc.Channel channel) {
    return new AuthStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static AuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static AuthVertxStub newVertxStub(io.grpc.Channel channel) {
    return new AuthVertxStub(channel);
  }

  /**
   */
  public static abstract class AuthImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public void authEnable(com.coreos.jetcd.api.AuthEnableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthEnableResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_ENABLE, responseObserver);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public void authDisable(com.coreos.jetcd.api.AuthDisableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthDisableResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_DISABLE, responseObserver);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public void authenticate(com.coreos.jetcd.api.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthenticateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AUTHENTICATE, responseObserver);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public void userAdd(com.coreos.jetcd.api.AuthUserAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserAddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_ADD, responseObserver);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public void userGet(com.coreos.jetcd.api.AuthUserGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_GET, responseObserver);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public void userList(com.coreos.jetcd.api.AuthUserListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_LIST, responseObserver);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public void userDelete(com.coreos.jetcd.api.AuthUserDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_DELETE, responseObserver);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public void userChangePassword(com.coreos.jetcd.api.AuthUserChangePasswordRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserChangePasswordResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_CHANGE_PASSWORD, responseObserver);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public void userGrantRole(com.coreos.jetcd.api.AuthUserGrantRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGrantRoleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_GRANT_ROLE, responseObserver);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public void userRevokeRole(com.coreos.jetcd.api.AuthUserRevokeRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserRevokeRoleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_USER_REVOKE_ROLE, responseObserver);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public void roleAdd(com.coreos.jetcd.api.AuthRoleAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleAddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_ADD, responseObserver);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public void roleGet(com.coreos.jetcd.api.AuthRoleGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_GET, responseObserver);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public void roleList(com.coreos.jetcd.api.AuthRoleListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_LIST, responseObserver);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public void roleDelete(com.coreos.jetcd.api.AuthRoleDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_DELETE, responseObserver);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public void roleGrantPermission(com.coreos.jetcd.api.AuthRoleGrantPermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_GRANT_PERMISSION, responseObserver);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public void roleRevokePermission(com.coreos.jetcd.api.AuthRoleRevokePermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_REVOKE_PERMISSION, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_AUTH_ENABLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthEnableRequest,
                com.coreos.jetcd.api.AuthEnableResponse>(
                  this, METHODID_AUTH_ENABLE)))
          .addMethod(
            METHOD_AUTH_DISABLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthDisableRequest,
                com.coreos.jetcd.api.AuthDisableResponse>(
                  this, METHODID_AUTH_DISABLE)))
          .addMethod(
            METHOD_AUTHENTICATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthenticateRequest,
                com.coreos.jetcd.api.AuthenticateResponse>(
                  this, METHODID_AUTHENTICATE)))
          .addMethod(
            METHOD_USER_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserAddRequest,
                com.coreos.jetcd.api.AuthUserAddResponse>(
                  this, METHODID_USER_ADD)))
          .addMethod(
            METHOD_USER_GET,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserGetRequest,
                com.coreos.jetcd.api.AuthUserGetResponse>(
                  this, METHODID_USER_GET)))
          .addMethod(
            METHOD_USER_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserListRequest,
                com.coreos.jetcd.api.AuthUserListResponse>(
                  this, METHODID_USER_LIST)))
          .addMethod(
            METHOD_USER_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserDeleteRequest,
                com.coreos.jetcd.api.AuthUserDeleteResponse>(
                  this, METHODID_USER_DELETE)))
          .addMethod(
            METHOD_USER_CHANGE_PASSWORD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserChangePasswordRequest,
                com.coreos.jetcd.api.AuthUserChangePasswordResponse>(
                  this, METHODID_USER_CHANGE_PASSWORD)))
          .addMethod(
            METHOD_USER_GRANT_ROLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserGrantRoleRequest,
                com.coreos.jetcd.api.AuthUserGrantRoleResponse>(
                  this, METHODID_USER_GRANT_ROLE)))
          .addMethod(
            METHOD_USER_REVOKE_ROLE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthUserRevokeRoleRequest,
                com.coreos.jetcd.api.AuthUserRevokeRoleResponse>(
                  this, METHODID_USER_REVOKE_ROLE)))
          .addMethod(
            METHOD_ROLE_ADD,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthRoleAddRequest,
                com.coreos.jetcd.api.AuthRoleAddResponse>(
                  this, METHODID_ROLE_ADD)))
          .addMethod(
            METHOD_ROLE_GET,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthRoleGetRequest,
                com.coreos.jetcd.api.AuthRoleGetResponse>(
                  this, METHODID_ROLE_GET)))
          .addMethod(
            METHOD_ROLE_LIST,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthRoleListRequest,
                com.coreos.jetcd.api.AuthRoleListResponse>(
                  this, METHODID_ROLE_LIST)))
          .addMethod(
            METHOD_ROLE_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthRoleDeleteRequest,
                com.coreos.jetcd.api.AuthRoleDeleteResponse>(
                  this, METHODID_ROLE_DELETE)))
          .addMethod(
            METHOD_ROLE_GRANT_PERMISSION,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthRoleGrantPermissionRequest,
                com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>(
                  this, METHODID_ROLE_GRANT_PERMISSION)))
          .addMethod(
            METHOD_ROLE_REVOKE_PERMISSION,
            asyncUnaryCall(
              new MethodHandlers<
                com.coreos.jetcd.api.AuthRoleRevokePermissionRequest,
                com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>(
                  this, METHODID_ROLE_REVOKE_PERMISSION)))
          .build();
    }
  }

  /**
   */
  public static final class AuthStub extends io.grpc.stub.AbstractStub<AuthStub> {
    private AuthStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public void authEnable(com.coreos.jetcd.api.AuthEnableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthEnableResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_ENABLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public void authDisable(com.coreos.jetcd.api.AuthDisableRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthDisableResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_DISABLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public void authenticate(com.coreos.jetcd.api.AuthenticateRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthenticateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public void userAdd(com.coreos.jetcd.api.AuthUserAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserAddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_ADD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public void userGet(com.coreos.jetcd.api.AuthUserGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_GET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public void userList(com.coreos.jetcd.api.AuthUserListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public void userDelete(com.coreos.jetcd.api.AuthUserDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public void userChangePassword(com.coreos.jetcd.api.AuthUserChangePasswordRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserChangePasswordResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_CHANGE_PASSWORD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public void userGrantRole(com.coreos.jetcd.api.AuthUserGrantRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGrantRoleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_GRANT_ROLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public void userRevokeRole(com.coreos.jetcd.api.AuthUserRevokeRoleRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserRevokeRoleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_REVOKE_ROLE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public void roleAdd(com.coreos.jetcd.api.AuthRoleAddRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleAddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_ADD, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public void roleGet(com.coreos.jetcd.api.AuthRoleGetRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_GET, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public void roleList(com.coreos.jetcd.api.AuthRoleListRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_LIST, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public void roleDelete(com.coreos.jetcd.api.AuthRoleDeleteRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public void roleGrantPermission(com.coreos.jetcd.api.AuthRoleGrantPermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_GRANT_PERMISSION, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public void roleRevokePermission(com.coreos.jetcd.api.AuthRoleRevokePermissionRequest request,
        io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_REVOKE_PERMISSION, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthBlockingStub extends io.grpc.stub.AbstractStub<AuthBlockingStub> {
    private AuthBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthEnableResponse authEnable(com.coreos.jetcd.api.AuthEnableRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTH_ENABLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthDisableResponse authDisable(com.coreos.jetcd.api.AuthDisableRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTH_DISABLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthenticateResponse authenticate(com.coreos.jetcd.api.AuthenticateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AUTHENTICATE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserAddResponse userAdd(com.coreos.jetcd.api.AuthUserAddRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_ADD, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserGetResponse userGet(com.coreos.jetcd.api.AuthUserGetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_GET, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserListResponse userList(com.coreos.jetcd.api.AuthUserListRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_LIST, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserDeleteResponse userDelete(com.coreos.jetcd.api.AuthUserDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_DELETE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserChangePasswordResponse userChangePassword(com.coreos.jetcd.api.AuthUserChangePasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_CHANGE_PASSWORD, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserGrantRoleResponse userGrantRole(com.coreos.jetcd.api.AuthUserGrantRoleRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_GRANT_ROLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthUserRevokeRoleResponse userRevokeRole(com.coreos.jetcd.api.AuthUserRevokeRoleRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_USER_REVOKE_ROLE, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthRoleAddResponse roleAdd(com.coreos.jetcd.api.AuthRoleAddRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_ADD, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthRoleGetResponse roleGet(com.coreos.jetcd.api.AuthRoleGetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_GET, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthRoleListResponse roleList(com.coreos.jetcd.api.AuthRoleListRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_LIST, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthRoleDeleteResponse roleDelete(com.coreos.jetcd.api.AuthRoleDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_DELETE, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthRoleGrantPermissionResponse roleGrantPermission(com.coreos.jetcd.api.AuthRoleGrantPermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_GRANT_PERMISSION, getCallOptions(), request);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public com.coreos.jetcd.api.AuthRoleRevokePermissionResponse roleRevokePermission(com.coreos.jetcd.api.AuthRoleRevokePermissionRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ROLE_REVOKE_PERMISSION, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthFutureStub extends io.grpc.stub.AbstractStub<AuthFutureStub> {
    private AuthFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthEnableResponse> authEnable(
        com.coreos.jetcd.api.AuthEnableRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTH_ENABLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthDisableResponse> authDisable(
        com.coreos.jetcd.api.AuthDisableRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTH_DISABLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthenticateResponse> authenticate(
        com.coreos.jetcd.api.AuthenticateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserAddResponse> userAdd(
        com.coreos.jetcd.api.AuthUserAddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_ADD, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserGetResponse> userGet(
        com.coreos.jetcd.api.AuthUserGetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_GET, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserListResponse> userList(
        com.coreos.jetcd.api.AuthUserListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_LIST, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserDeleteResponse> userDelete(
        com.coreos.jetcd.api.AuthUserDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_DELETE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserChangePasswordResponse> userChangePassword(
        com.coreos.jetcd.api.AuthUserChangePasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_CHANGE_PASSWORD, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserGrantRoleResponse> userGrantRole(
        com.coreos.jetcd.api.AuthUserGrantRoleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_GRANT_ROLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthUserRevokeRoleResponse> userRevokeRole(
        com.coreos.jetcd.api.AuthUserRevokeRoleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_USER_REVOKE_ROLE, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthRoleAddResponse> roleAdd(
        com.coreos.jetcd.api.AuthRoleAddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_ADD, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthRoleGetResponse> roleGet(
        com.coreos.jetcd.api.AuthRoleGetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_GET, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthRoleListResponse> roleList(
        com.coreos.jetcd.api.AuthRoleListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_LIST, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthRoleDeleteResponse> roleDelete(
        com.coreos.jetcd.api.AuthRoleDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_DELETE, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse> roleGrantPermission(
        com.coreos.jetcd.api.AuthRoleGrantPermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_GRANT_PERMISSION, getCallOptions()), request);
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse> roleRevokePermission(
        com.coreos.jetcd.api.AuthRoleRevokePermissionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ROLE_REVOKE_PERMISSION, getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class AuthVertxImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public void authEnable(com.coreos.jetcd.api.AuthEnableRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthEnableResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_ENABLE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public void authDisable(com.coreos.jetcd.api.AuthDisableRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthDisableResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_AUTH_DISABLE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public void authenticate(com.coreos.jetcd.api.AuthenticateRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthenticateResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_AUTHENTICATE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public void userAdd(com.coreos.jetcd.api.AuthUserAddRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserAddResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_ADD, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public void userGet(com.coreos.jetcd.api.AuthUserGetRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserGetResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_GET, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public void userList(com.coreos.jetcd.api.AuthUserListRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserListResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_LIST, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public void userDelete(com.coreos.jetcd.api.AuthUserDeleteRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserDeleteResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_DELETE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public void userChangePassword(com.coreos.jetcd.api.AuthUserChangePasswordRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserChangePasswordResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_CHANGE_PASSWORD, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public void userGrantRole(com.coreos.jetcd.api.AuthUserGrantRoleRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserGrantRoleResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_GRANT_ROLE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public void userRevokeRole(com.coreos.jetcd.api.AuthUserRevokeRoleRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthUserRevokeRoleResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_USER_REVOKE_ROLE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public void roleAdd(com.coreos.jetcd.api.AuthRoleAddRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleAddResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_ADD, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public void roleGet(com.coreos.jetcd.api.AuthRoleGetRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleGetResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_GET, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public void roleList(com.coreos.jetcd.api.AuthRoleListRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleListResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_LIST, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public void roleDelete(com.coreos.jetcd.api.AuthRoleDeleteRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleDeleteResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_DELETE, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public void roleGrantPermission(com.coreos.jetcd.api.AuthRoleGrantPermissionRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_GRANT_PERMISSION, AuthGrpc.toObserver(response.completer()));
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public void roleRevokePermission(com.coreos.jetcd.api.AuthRoleRevokePermissionRequest request,
        io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse> response) {
      asyncUnimplementedUnaryCall(METHOD_ROLE_REVOKE_PERMISSION, AuthGrpc.toObserver(response.completer()));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_AUTH_ENABLE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthEnableRequest,
                com.coreos.jetcd.api.AuthEnableResponse>(
                  this, METHODID_AUTH_ENABLE)))
          .addMethod(
            METHOD_AUTH_DISABLE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthDisableRequest,
                com.coreos.jetcd.api.AuthDisableResponse>(
                  this, METHODID_AUTH_DISABLE)))
          .addMethod(
            METHOD_AUTHENTICATE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthenticateRequest,
                com.coreos.jetcd.api.AuthenticateResponse>(
                  this, METHODID_AUTHENTICATE)))
          .addMethod(
            METHOD_USER_ADD,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserAddRequest,
                com.coreos.jetcd.api.AuthUserAddResponse>(
                  this, METHODID_USER_ADD)))
          .addMethod(
            METHOD_USER_GET,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserGetRequest,
                com.coreos.jetcd.api.AuthUserGetResponse>(
                  this, METHODID_USER_GET)))
          .addMethod(
            METHOD_USER_LIST,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserListRequest,
                com.coreos.jetcd.api.AuthUserListResponse>(
                  this, METHODID_USER_LIST)))
          .addMethod(
            METHOD_USER_DELETE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserDeleteRequest,
                com.coreos.jetcd.api.AuthUserDeleteResponse>(
                  this, METHODID_USER_DELETE)))
          .addMethod(
            METHOD_USER_CHANGE_PASSWORD,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserChangePasswordRequest,
                com.coreos.jetcd.api.AuthUserChangePasswordResponse>(
                  this, METHODID_USER_CHANGE_PASSWORD)))
          .addMethod(
            METHOD_USER_GRANT_ROLE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserGrantRoleRequest,
                com.coreos.jetcd.api.AuthUserGrantRoleResponse>(
                  this, METHODID_USER_GRANT_ROLE)))
          .addMethod(
            METHOD_USER_REVOKE_ROLE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthUserRevokeRoleRequest,
                com.coreos.jetcd.api.AuthUserRevokeRoleResponse>(
                  this, METHODID_USER_REVOKE_ROLE)))
          .addMethod(
            METHOD_ROLE_ADD,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthRoleAddRequest,
                com.coreos.jetcd.api.AuthRoleAddResponse>(
                  this, METHODID_ROLE_ADD)))
          .addMethod(
            METHOD_ROLE_GET,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthRoleGetRequest,
                com.coreos.jetcd.api.AuthRoleGetResponse>(
                  this, METHODID_ROLE_GET)))
          .addMethod(
            METHOD_ROLE_LIST,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthRoleListRequest,
                com.coreos.jetcd.api.AuthRoleListResponse>(
                  this, METHODID_ROLE_LIST)))
          .addMethod(
            METHOD_ROLE_DELETE,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthRoleDeleteRequest,
                com.coreos.jetcd.api.AuthRoleDeleteResponse>(
                  this, METHODID_ROLE_DELETE)))
          .addMethod(
            METHOD_ROLE_GRANT_PERMISSION,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthRoleGrantPermissionRequest,
                com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>(
                  this, METHODID_ROLE_GRANT_PERMISSION)))
          .addMethod(
            METHOD_ROLE_REVOKE_PERMISSION,
            asyncUnaryCall(
              new VertxMethodHandlers<
                com.coreos.jetcd.api.AuthRoleRevokePermissionRequest,
                com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>(
                  this, METHODID_ROLE_REVOKE_PERMISSION)))
          .build();
    }
  }

  /**
   */
  public static final class AuthVertxStub extends io.grpc.stub.AbstractStub<AuthVertxStub> {
    private AuthVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthVertxStub(channel, callOptions);
    }

    /**
     * <pre>
     * AuthEnable enables authentication.
     * </pre>
     */
    public void authEnable(com.coreos.jetcd.api.AuthEnableRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthEnableResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_ENABLE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * AuthDisable disables authentication.
     * </pre>
     */
    public void authDisable(com.coreos.jetcd.api.AuthDisableRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthDisableResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTH_DISABLE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * Authenticate processes an authenticate request.
     * </pre>
     */
    public void authenticate(com.coreos.jetcd.api.AuthenticateRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthenticateResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AUTHENTICATE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserAdd adds a new user.
     * </pre>
     */
    public void userAdd(com.coreos.jetcd.api.AuthUserAddRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserAddResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_ADD, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserGet gets detailed user information.
     * </pre>
     */
    public void userGet(com.coreos.jetcd.api.AuthUserGetRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserGetResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_GET, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserList gets a list of all users.
     * </pre>
     */
    public void userList(com.coreos.jetcd.api.AuthUserListRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserListResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_LIST, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserDelete deletes a specified user.
     * </pre>
     */
    public void userDelete(com.coreos.jetcd.api.AuthUserDeleteRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserDeleteResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_DELETE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserChangePassword changes the password of a specified user.
     * </pre>
     */
    public void userChangePassword(com.coreos.jetcd.api.AuthUserChangePasswordRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserChangePasswordResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_CHANGE_PASSWORD, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserGrant grants a role to a specified user.
     * </pre>
     */
    public void userGrantRole(com.coreos.jetcd.api.AuthUserGrantRoleRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserGrantRoleResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_GRANT_ROLE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * UserRevokeRole revokes a role of specified user.
     * </pre>
     */
    public void userRevokeRole(com.coreos.jetcd.api.AuthUserRevokeRoleRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthUserRevokeRoleResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_USER_REVOKE_ROLE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * RoleAdd adds a new role.
     * </pre>
     */
    public void roleAdd(com.coreos.jetcd.api.AuthRoleAddRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthRoleAddResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_ADD, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * RoleGet gets detailed role information.
     * </pre>
     */
    public void roleGet(com.coreos.jetcd.api.AuthRoleGetRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthRoleGetResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_GET, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * RoleList gets lists of all roles.
     * </pre>
     */
    public void roleList(com.coreos.jetcd.api.AuthRoleListRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthRoleListResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_LIST, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * RoleDelete deletes a specified role.
     * </pre>
     */
    public void roleDelete(com.coreos.jetcd.api.AuthRoleDeleteRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthRoleDeleteResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_DELETE, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * RoleGrantPermission grants a permission of a specified key or range to a specified role.
     * </pre>
     */
    public void roleGrantPermission(com.coreos.jetcd.api.AuthRoleGrantPermissionRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_GRANT_PERMISSION, getCallOptions()), request, AuthGrpc.toObserver(response));
    }

    /**
     * <pre>
     * RoleRevokePermission revokes a key or range permission of a specified role.
     * </pre>
     */
    public void roleRevokePermission(com.coreos.jetcd.api.AuthRoleRevokePermissionRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ROLE_REVOKE_PERMISSION, getCallOptions()), request, AuthGrpc.toObserver(response));
    }
  }

  private static final int METHODID_AUTH_ENABLE = 0;
  private static final int METHODID_AUTH_DISABLE = 1;
  private static final int METHODID_AUTHENTICATE = 2;
  private static final int METHODID_USER_ADD = 3;
  private static final int METHODID_USER_GET = 4;
  private static final int METHODID_USER_LIST = 5;
  private static final int METHODID_USER_DELETE = 6;
  private static final int METHODID_USER_CHANGE_PASSWORD = 7;
  private static final int METHODID_USER_GRANT_ROLE = 8;
  private static final int METHODID_USER_REVOKE_ROLE = 9;
  private static final int METHODID_ROLE_ADD = 10;
  private static final int METHODID_ROLE_GET = 11;
  private static final int METHODID_ROLE_LIST = 12;
  private static final int METHODID_ROLE_DELETE = 13;
  private static final int METHODID_ROLE_GRANT_PERMISSION = 14;
  private static final int METHODID_ROLE_REVOKE_PERMISSION = 15;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTH_ENABLE:
          serviceImpl.authEnable((com.coreos.jetcd.api.AuthEnableRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthEnableResponse>) responseObserver);
          break;
        case METHODID_AUTH_DISABLE:
          serviceImpl.authDisable((com.coreos.jetcd.api.AuthDisableRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthDisableResponse>) responseObserver);
          break;
        case METHODID_AUTHENTICATE:
          serviceImpl.authenticate((com.coreos.jetcd.api.AuthenticateRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthenticateResponse>) responseObserver);
          break;
        case METHODID_USER_ADD:
          serviceImpl.userAdd((com.coreos.jetcd.api.AuthUserAddRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserAddResponse>) responseObserver);
          break;
        case METHODID_USER_GET:
          serviceImpl.userGet((com.coreos.jetcd.api.AuthUserGetRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGetResponse>) responseObserver);
          break;
        case METHODID_USER_LIST:
          serviceImpl.userList((com.coreos.jetcd.api.AuthUserListRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserListResponse>) responseObserver);
          break;
        case METHODID_USER_DELETE:
          serviceImpl.userDelete((com.coreos.jetcd.api.AuthUserDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserDeleteResponse>) responseObserver);
          break;
        case METHODID_USER_CHANGE_PASSWORD:
          serviceImpl.userChangePassword((com.coreos.jetcd.api.AuthUserChangePasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserChangePasswordResponse>) responseObserver);
          break;
        case METHODID_USER_GRANT_ROLE:
          serviceImpl.userGrantRole((com.coreos.jetcd.api.AuthUserGrantRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGrantRoleResponse>) responseObserver);
          break;
        case METHODID_USER_REVOKE_ROLE:
          serviceImpl.userRevokeRole((com.coreos.jetcd.api.AuthUserRevokeRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserRevokeRoleResponse>) responseObserver);
          break;
        case METHODID_ROLE_ADD:
          serviceImpl.roleAdd((com.coreos.jetcd.api.AuthRoleAddRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleAddResponse>) responseObserver);
          break;
        case METHODID_ROLE_GET:
          serviceImpl.roleGet((com.coreos.jetcd.api.AuthRoleGetRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGetResponse>) responseObserver);
          break;
        case METHODID_ROLE_LIST:
          serviceImpl.roleList((com.coreos.jetcd.api.AuthRoleListRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleListResponse>) responseObserver);
          break;
        case METHODID_ROLE_DELETE:
          serviceImpl.roleDelete((com.coreos.jetcd.api.AuthRoleDeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleDeleteResponse>) responseObserver);
          break;
        case METHODID_ROLE_GRANT_PERMISSION:
          serviceImpl.roleGrantPermission((com.coreos.jetcd.api.AuthRoleGrantPermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>) responseObserver);
          break;
        case METHODID_ROLE_REVOKE_PERMISSION:
          serviceImpl.roleRevokePermission((com.coreos.jetcd.api.AuthRoleRevokePermissionRequest) request,
              (io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>) responseObserver);
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
    private final AuthVertxImplBase serviceImpl;
    private final int methodId;

    VertxMethodHandlers(AuthVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTH_ENABLE:
          serviceImpl.authEnable((com.coreos.jetcd.api.AuthEnableRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthEnableResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthEnableResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthEnableResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_AUTH_DISABLE:
          serviceImpl.authDisable((com.coreos.jetcd.api.AuthDisableRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthDisableResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthDisableResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthDisableResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_AUTHENTICATE:
          serviceImpl.authenticate((com.coreos.jetcd.api.AuthenticateRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthenticateResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthenticateResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthenticateResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_ADD:
          serviceImpl.userAdd((com.coreos.jetcd.api.AuthUserAddRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserAddResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserAddResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserAddResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_GET:
          serviceImpl.userGet((com.coreos.jetcd.api.AuthUserGetRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserGetResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserGetResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGetResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_LIST:
          serviceImpl.userList((com.coreos.jetcd.api.AuthUserListRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserListResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserListResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserListResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_DELETE:
          serviceImpl.userDelete((com.coreos.jetcd.api.AuthUserDeleteRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserDeleteResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserDeleteResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserDeleteResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_CHANGE_PASSWORD:
          serviceImpl.userChangePassword((com.coreos.jetcd.api.AuthUserChangePasswordRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserChangePasswordResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserChangePasswordResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserChangePasswordResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_GRANT_ROLE:
          serviceImpl.userGrantRole((com.coreos.jetcd.api.AuthUserGrantRoleRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserGrantRoleResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserGrantRoleResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserGrantRoleResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_USER_REVOKE_ROLE:
          serviceImpl.userRevokeRole((com.coreos.jetcd.api.AuthUserRevokeRoleRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthUserRevokeRoleResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthUserRevokeRoleResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthUserRevokeRoleResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_ROLE_ADD:
          serviceImpl.roleAdd((com.coreos.jetcd.api.AuthRoleAddRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleAddResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthRoleAddResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleAddResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_ROLE_GET:
          serviceImpl.roleGet((com.coreos.jetcd.api.AuthRoleGetRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleGetResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthRoleGetResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGetResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_ROLE_LIST:
          serviceImpl.roleList((com.coreos.jetcd.api.AuthRoleListRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleListResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthRoleListResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleListResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_ROLE_DELETE:
          serviceImpl.roleDelete((com.coreos.jetcd.api.AuthRoleDeleteRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleDeleteResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthRoleDeleteResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleDeleteResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_ROLE_GRANT_PERMISSION:
          serviceImpl.roleGrantPermission((com.coreos.jetcd.api.AuthRoleGrantPermissionRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
          break;
        case METHODID_ROLE_REVOKE_PERMISSION:
          serviceImpl.roleRevokePermission((com.coreos.jetcd.api.AuthRoleRevokePermissionRequest) request,
              (io.vertx.core.Future<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>) io.vertx.core.Future.<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>) responseObserver).onNext(ar.result());
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

  private static final class AuthDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.coreos.jetcd.api.JetcdProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthDescriptorSupplier())
              .addMethod(METHOD_AUTH_ENABLE)
              .addMethod(METHOD_AUTH_DISABLE)
              .addMethod(METHOD_AUTHENTICATE)
              .addMethod(METHOD_USER_ADD)
              .addMethod(METHOD_USER_GET)
              .addMethod(METHOD_USER_LIST)
              .addMethod(METHOD_USER_DELETE)
              .addMethod(METHOD_USER_CHANGE_PASSWORD)
              .addMethod(METHOD_USER_GRANT_ROLE)
              .addMethod(METHOD_USER_REVOKE_ROLE)
              .addMethod(METHOD_ROLE_ADD)
              .addMethod(METHOD_ROLE_GET)
              .addMethod(METHOD_ROLE_LIST)
              .addMethod(METHOD_ROLE_DELETE)
              .addMethod(METHOD_ROLE_GRANT_PERMISSION)
              .addMethod(METHOD_ROLE_REVOKE_PERMISSION)
              .build();
        }
      }
    }
    return result;
  }
}
