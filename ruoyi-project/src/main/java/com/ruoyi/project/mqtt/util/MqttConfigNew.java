package com.ruoyi.project.mqtt.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * mqtt配置类，获取mqtt连接
 */
@Component
@Data
public class MqttConfigNew {

//    private MqttPushClientNew mqttPushClientNew;

    private String host="tcp://114.55.173.94:1883";
//    @Value("${mqtt.clientid}")
    private String clientId;

    private String userName="admin";

    private String password="public";

    private String topic="virus";

    private int timeout=10000;

    private int keepAlive=20;


    /**
     * 连接至mqtt服务器，获取mqtt连接
     * @return
     */
    public MqttPushClientNew getMqttPushClientNew() {
        MqttPushClientNew mqttPushClientNew =  new MqttPushClientNew();
        //连接至mqtt服务器，获取mqtt连接
        mqttPushClientNew.connect(host, clientId, userName, password, timeout, keepAlive);
        //一连接mqtt,就订阅默认需要订阅的主题（如test_queue）
        new MqttSubClientNew(mqttPushClientNew);
        return mqttPushClientNew;
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