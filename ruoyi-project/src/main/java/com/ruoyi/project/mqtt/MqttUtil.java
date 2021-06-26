package com.ruoyi.project.mqtt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqttUtil {

    @Autowired
    private MqttPushClient mqttPushClient;

    public void testPublishMessage(String topic, Map<String,Object> data) {
        mqttPushClient.publish(topic,data);
    }
}
