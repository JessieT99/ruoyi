package com.ruoyi.project.mqtt.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Component;

/**
 * @Author:Dong
 * @Date：2020/7/31 9:59
 */
@Data
@Slf4j
@Component
public class MqttSubClientNew {

    private MqttPushClientNew mqttPushClient;

    public MqttSubClientNew(MqttPushClientNew mqttPushClient){
        this.mqttPushClient = mqttPushClient;
        subScribeDataPublishTopic();
    }


    private void subScribeDataPublishTopic(){
        //订阅test_queue主题
       subscribe("test_queue");
       subscribe("yrd");
    }

    /**
     * 订阅某个主题，qos默认为0
     *
     * @param topic
     */
    public void subscribe(String topic) {
        subscribe(topic, 0);
    }

    /**
     * 订阅某个主题
     *
     * @param topic 主题名
     * @param qos
     */
    public void subscribe(String topic, int qos) {
        try {
            MqttClient client = mqttPushClient.getClient();
            if (client == null) return;
            client.subscribe(topic, qos);
            log.info("订阅主题:{}",topic);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
