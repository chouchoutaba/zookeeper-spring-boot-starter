package com.gphw.starter.zookeeper;

import com.gphw.starter.zookeeper.autoconfiguration.ZookeeperProperties;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @Author: Jiang
 * @Date: 2019/7/27 9:52
 */
public class ZookeeperTemplate {
    private ZookeeperProperties zookeeperProperties;

    public ZookeeperTemplate(ZookeeperProperties zookeeperProperties) {
        this.zookeeperProperties = zookeeperProperties;
    }

    private static CuratorFramework curatorFramework = null;


    public void createData(String path,String data) throws Exception {
        if(null==curatorFramework ){
            initCuratorFramework();
        }
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                .forPath(path,data.getBytes());
    }

    private void initCuratorFramework(){
        synchronized (ZookeeperTemplate.class) {
            curatorFramework = CuratorFrameworkFactory.builder().connectString(zookeeperProperties.getConnect_str())
                    .sessionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
                    .namespace(zookeeperProperties.getNameSpace()).build();
            curatorFramework.start();
        }
    }

}
