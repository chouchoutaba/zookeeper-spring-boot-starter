package com.gphw.starter.zookeeper.autoconfiguration;

import com.gphw.starter.zookeeper.ZookeeperTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jiang
 * @Date: 2019/7/27 9:55
 */
@EnableConfigurationProperties({ZookeeperProperties.class})
@Configuration
public class ZookeeperAutoConfiguration {

    @Bean
    public ZookeeperTemplate zookeeperTemplate(ZookeeperProperties zookeeperProperties){
        return new ZookeeperTemplate(zookeeperProperties);
    }
}
