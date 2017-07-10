package io.vertx.test.core;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.etcd.EtcdClusterManager;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdClusterWideMapTest extends ClusterWideMapTest {

  @Override
  protected ClusterManager getClusterManager() {
    return new EtcdClusterManager("l-fedev2.ops.bj0.daling.com", 2379);
  }

}
