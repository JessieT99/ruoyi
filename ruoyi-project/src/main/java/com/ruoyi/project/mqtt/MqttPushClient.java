package com.ruoyi.project.mqtt;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MqttPushClient{

    @Lazy
    @Autowired
    private PushCallback pushCallback;

    private static MqttClient client;


    public static void setClient(MqttClient client) {
        MqttPushClient.client = client;
    }

    public static MqttClient getClient() {
        return client;
    }

    public void connect(String host, String clientId, String username, String password, int timeout, int keepalive) {
        MqttClient client;
        try {
            client = new MqttClient(host, clientId, new MemoryPersistence());
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(true);
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(timeout);
            options.setKeepAliveInterval(keepalive);
            MqttPushClient.setClient(client);
            try {
                //设置回调类
                client.setCallback(pushCallback);
                //client.connect(options);
                IMqttToken iMqttToken = client.connectWithResult(options);
                boolean complete = iMqttToken.isComplete();
                log.info("MQTT连接"+(complete?"成功":"失败"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 发布，默认qos为0，非持久化
     *
     * @param topic 主题名
     * @param pushMessage 消息
     */
    public void publish(String topic, Map<String,Object> pushMessage) {
        publish(0, false, topic, pushMessage);
    }

    /**
     * 发布
     *
     * @param qos
     * @param retained
     * @param topic
     * @param pushMessage
     */
    public void publish(int qos, boolean retained, String topic, Map<String,Object> pushMessage) {
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(retained);
        message.setPayload(JSON.toJSONString(pushMessage).getBytes());
        MqttTopic mTopic = MqttPushClient.getClient().getTopic(topic);
        if (null == mTopic) {
            log.error("主题不存在:{}",mTopic);
        }
        try {
            mTopic.publish(message);
        } catch (Exception e) {
            log.error("mqtt发送消息异常:",e);
        }
    }

}