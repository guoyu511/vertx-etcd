package io.vertx.test.core;

import com.coreos.jetcd.api.DeleteRangeRequest;
import com.coreos.jetcd.api.KVGrpc;
import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class TestCleaner {

  public static void clear() {
    ManagedChannel channel = NettyChannelBuilder.forAddress("localhost", 2379)
      .usePlaintext(true).build();
    KVGrpc.KVBlockingStub stub = KVGrpc.newBlockingStub(channel);
    stub.deleteRange(DeleteRangeRequest.newBuilder()
      .setKey(ByteString.copyFrom(new byte[]{ 0 }))
      .setRangeEnd(ByteString.copyFrom(new byte[]{ 0 }))
      .build());
  }

}
