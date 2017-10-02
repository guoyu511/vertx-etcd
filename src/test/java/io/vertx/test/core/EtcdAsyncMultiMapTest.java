package io.vertx.test.core;

import com.coreos.jetcd.api.DeleteRangeRequest;
import com.google.protobuf.ByteString;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.etcd.EtcdClusterManager;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMultiMapTest extends AsyncMultiMapTest {

  private EtcdClusterManager clusterManager;

  @Override
  public void after() throws Exception {
    clusterManager.getKVStub()
      .deleteRange(DeleteRangeRequest.newBuilder()
        .setKey(ByteString.copyFromUtf8("test-vertx-cluster/"))
        .setRangeEnd(ByteString.copyFromUtf8("test-vertx-cluster0"))
        .build());
    super.after();
  }

  @Override
  protected ClusterManager getClusterManager() {
    return clusterManager = new EtcdClusterManager("127.0.0.1", 2379, "test-vertx-cluster");
  }

}
