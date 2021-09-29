package com.ruoyi.project.mqtt.util;

import com.ruoyi.project.config.CoreBaseDataLoaderMqttClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: ruoyi
 * @description:
 * @author: junjie.tan
 * @create: 2021-09-29 17:26
 **/
@Component
public class MqttPublishUtil {

    public void publish(String code,Map<String,Object> data){
        Map<String, MqttPushClientNew> map =  CoreBaseDataLoaderMqttClient.MQTT_PUSH_CLIENT_MAP;
        MqttPushClientNew mqttPushClientNew = map.get(code);
        mqttPushClientNew.publish(code,data);
    }

}
