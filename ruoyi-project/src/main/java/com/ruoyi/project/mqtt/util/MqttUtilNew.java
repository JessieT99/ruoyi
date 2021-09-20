package com.ruoyi.project.mqtt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqttUtilNew {

    @Autowired
    private MqttPushClientNew mqttPushClient;

    public void testPublishMessage(String topic, Map<String,Object> data) {
        mqttPushClient.publish(topic,data);

    }

}
