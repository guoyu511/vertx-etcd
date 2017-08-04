package io.vertx.test.core;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.etcd.EtcdClusterManager;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class EtcdAsyncMultiMapTest extends AsyncMultiMapTest {

  @Override
  protected ClusterManager getClusterManager() {
    return new EtcdClusterManager("10.36.4.55", 2379);
  }

}
