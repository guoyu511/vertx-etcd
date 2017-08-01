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
public final class AuthGrpc {

  private AuthGrpc() {}

  public static final String SERVICE_NAME = "etcdserverpb.Auth";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthEnableRequest,
      com.coreos.jetcd.api.AuthEnableResponse> METHOD_AUTH_ENABLE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthEnableRequest, com.coreos.jetcd.api.AuthEnableResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "AuthEnable"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthEnableRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthEnableResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthDisableRequest,
      com.coreos.jetcd.api.AuthDisableResponse> METHOD_AUTH_DISABLE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthDisableRequest, com.coreos.jetcd.api.AuthDisableResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "AuthDisable"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthDisableRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthDisableResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthenticateRequest,
      com.coreos.jetcd.api.AuthenticateResponse> METHOD_AUTHENTICATE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthenticateRequest, com.coreos.jetcd.api.AuthenticateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "Authenticate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthenticateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthenticateResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserAddRequest,
      com.coreos.jetcd.api.AuthUserAddResponse> METHOD_USER_ADD =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserAddRequest, com.coreos.jetcd.api.AuthUserAddResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserAdd"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserAddRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserAddResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserGetRequest,
      com.coreos.jetcd.api.AuthUserGetResponse> METHOD_USER_GET =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserGetRequest, com.coreos.jetcd.api.AuthUserGetResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserGet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserGetRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserGetResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserListRequest,
      com.coreos.jetcd.api.AuthUserListResponse> METHOD_USER_LIST =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserListRequest, com.coreos.jetcd.api.AuthUserListResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserListRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserListResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserDeleteRequest,
      com.coreos.jetcd.api.AuthUserDeleteResponse> METHOD_USER_DELETE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserDeleteRequest, com.coreos.jetcd.api.AuthUserDeleteResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserDelete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserDeleteRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserDeleteResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserChangePasswordRequest,
      com.coreos.jetcd.api.AuthUserChangePasswordResponse> METHOD_USER_CHANGE_PASSWORD =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserChangePasswordRequest, com.coreos.jetcd.api.AuthUserChangePasswordResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserChangePassword"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserChangePasswordRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserChangePasswordResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserGrantRoleRequest,
      com.coreos.jetcd.api.AuthUserGrantRoleResponse> METHOD_USER_GRANT_ROLE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserGrantRoleRequest, com.coreos.jetcd.api.AuthUserGrantRoleResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserGrantRole"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserGrantRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserGrantRoleResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthUserRevokeRoleRequest,
      com.coreos.jetcd.api.AuthUserRevokeRoleResponse> METHOD_USER_REVOKE_ROLE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthUserRevokeRoleRequest, com.coreos.jetcd.api.AuthUserRevokeRoleResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "UserRevokeRole"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserRevokeRoleRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthUserRevokeRoleResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleAddRequest,
      com.coreos.jetcd.api.AuthRoleAddResponse> METHOD_ROLE_ADD =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthRoleAddRequest, com.coreos.jetcd.api.AuthRoleAddResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "RoleAdd"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleAddRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleAddResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleGetRequest,
      com.coreos.jetcd.api.AuthRoleGetResponse> METHOD_ROLE_GET =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthRoleGetRequest, com.coreos.jetcd.api.AuthRoleGetResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "RoleGet"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleGetRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleGetResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleListRequest,
      com.coreos.jetcd.api.AuthRoleListResponse> METHOD_ROLE_LIST =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthRoleListRequest, com.coreos.jetcd.api.AuthRoleListResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "RoleList"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleListRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleListResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleDeleteRequest,
      com.coreos.jetcd.api.AuthRoleDeleteResponse> METHOD_ROLE_DELETE =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthRoleDeleteRequest, com.coreos.jetcd.api.AuthRoleDeleteResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "RoleDelete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleDeleteRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleDeleteResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleGrantPermissionRequest,
      com.coreos.jetcd.api.AuthRoleGrantPermissionResponse> METHOD_ROLE_GRANT_PERMISSION =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthRoleGrantPermissionRequest, com.coreos.jetcd.api.AuthRoleGrantPermissionResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "RoleGrantPermission"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleGrantPermissionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleGrantPermissionResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.coreos.jetcd.api.AuthRoleRevokePermissionRequest,
      com.coreos.jetcd.api.AuthRoleRevokePermissionResponse> METHOD_ROLE_REVOKE_PERMISSION =
      io.grpc.MethodDescriptor.<com.coreos.jetcd.api.AuthRoleRevokePermissionRequest, com.coreos.jetcd.api.AuthRoleRevokePermissionResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "etcdserverpb.Auth", "RoleRevokePermission"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleRevokePermissionRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.coreos.jetcd.api.AuthRoleRevokePermissionResponse.getDefaultInstance()))
          .build();

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
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthFutureStub(channel);
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
