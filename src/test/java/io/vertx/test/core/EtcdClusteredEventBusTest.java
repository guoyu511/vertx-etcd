package io.vertx.test.core;

import static io.vertx.test.core.TestCleaner.clear;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.etcd.EtcdClusterManager;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdClusteredEventBusTest extends ClusteredEventBusTest {

  @Override
  public void setUp() throws Exception {
    clear();
    super.setUp();
  }

  @Override
  protected ClusterManager getClusterManager() {
    return new EtcdClusterManager("localhost", 2379, "vertx-test");
  }

}
