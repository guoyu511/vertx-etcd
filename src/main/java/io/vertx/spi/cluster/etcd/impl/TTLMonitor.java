package io.vertx.spi.cluster.etcd.impl;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.spi.cluster.etcd.EtcdClusterManager;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class TTLMonitor {

  private static final String TTL_ADDRESS = "etcd-cluster-ttl";

  private EventBus eventBus;

  private EtcdClusterManager clusterManager;

  public TTLMonitor(Vertx vertx, EtcdClusterManager clusterManager) {
    this.clusterManager = clusterManager;
    eventBus = vertx.eventBus();
    eventBus.consumer(TTL_ADDRESS, this::handleMessage);
  }

  private void handleMessage(Message<String> msg) {
    //String key = ttlMessage.body();

  }

}
