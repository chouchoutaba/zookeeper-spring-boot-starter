package com.gphw.starter.zookeeper.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: Jiang
 * @Date: 2019/7/26 17:29
 */
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(
        prefix = ZookeeperProperties.ZOOKEEPER_CONFIG_PREFIX
)
public class ZookeeperProperties {
    public static final String ZOOKEEPER_CONFIG_PREFIX = "gphw.zookeeper.config";
    private String connect_str;
    private int timeOut;
    private int baseSleepTimeMs;
    private int maxRetries;
    private String nameSpace;


    public String getConnect_str() {
        return connect_str;
    }

    public void setConnect_str(String connect_str) {
        this.connect_str = connect_str;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public int getBaseSleepTimeMs() {
        return baseSleepTimeMs;
    }

    public void setBaseSleepTimeMs(int baseSleepTimeMs) {
        this.baseSleepTimeMs = baseSleepTimeMs;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }
}
