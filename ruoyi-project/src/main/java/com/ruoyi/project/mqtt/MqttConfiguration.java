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

    /*
    *方法：后台开个超级权限的MQTT客户端
           订阅所需的主题
           Qos设置成2，保证只接收一次，数据不会丢，也不会多
           将接收到的消息存储到数据库
    *
    * 了解到mqtt特性，客户端都是唯一的，发布订阅模式，建立mqtt_root超级客户端，订阅所有主题。主题暂定test_queue。
    * */
}