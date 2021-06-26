package com.ruoyi.project.mqtt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * mqtt配置类，获取mqtt连接
 */
@Component
@Configuration
@Data
public class MqttConfiguration {

    @Autowired
    private MqttPushClient mqttPushClient;
    @Value("${mqtt.host}")
    private String host;
    @Value("${mqtt.clientid}")
    private String clientId;
    @Value("${mqtt.username}")
    private String userName;
    @Value("${mqtt.password}")
    private String password;
    @Value("${mqtt.topic}")
    private String topic;
    @Value("${mqtt.timeout}")
    private int timeout;
    @Value("${mqtt.keepalive}")
    private int keepAlive;


    /**
     * 连接至mqtt服务器，获取mqtt连接
     * @return
     */
    @Bean
    public MqttPushClient getMqttPushClient() {
        //连接至mqtt服务器，获取mqtt连接
        mqttPushClient.connect(host, clientId, userName, password, timeout, keepAlive);
        //一连接mqtt,就订阅默认需要订阅的主题（如test_queue）
        new MqttSubClient(mqttPushClient);
        return mqttPushClient;
    }
}