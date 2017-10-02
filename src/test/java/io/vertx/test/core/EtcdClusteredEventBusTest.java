package io.vertx.test.core;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.etcd.EtcdClusterManager;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdClusteredEventBusTest extends ClusteredEventBusTest {

  @Override
  protected ClusterManager getClusterManager() {
    return new EtcdClusterManager("127.0.0.1", 2379, "test-vertx-cluster");
  }

}
