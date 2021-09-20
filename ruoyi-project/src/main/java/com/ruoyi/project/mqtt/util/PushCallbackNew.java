package com.ruoyi.project.mqtt.util;

import com.ruoyi.project.domain.HzMqttReceiveLog;
import com.ruoyi.project.service.IHzMqttReceiveLogService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class PushCallbackNew implements MqttCallback {

    @Autowired
    private MqttConfigNew mqttConfigNew;

    @Autowired
    private IHzMqttReceiveLogService hzMqttReceiveLogService;


    @Override
    public void connectionLost(Throwable cause) {        // 连接丢失后，一般在这里面进行重连
        log.info("连接断开，正在重连");
        MqttPushClientNew mqttPushClient = mqttConfigNew.getMqttPushClientNew();
        if (null != mqttPushClient) {
            mqttPushClient.connect(mqttConfigNew.getHost(), mqttConfigNew.getClientId(), mqttConfigNew.getUserName(),
                    mqttConfigNew.getPassword(), mqttConfigNew.getTimeout(), mqttConfigNew.getKeepAlive());
            log.info("已重连");
        }

    }

    /**
     * 发送消息，消息到达后处理方法
     * @param token
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {

    }

    /**
     * 订阅主题接收到消息处理方法
     * @param topic
     * @param message
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        // subscribe后得到的消息会执行到这里面,这里在控制台有输出
        log.info("接收消息主题 : " + topic);
        log.info("接收消息Qos : " + message.getQos());
        log.info("接收消息内容 : " + new String(message.getPayload()));
        log.info("接收信息："+message.getId());
        HzMqttReceiveLog mqttReceiveLog = new HzMqttReceiveLog();
        mqttReceiveLog.setClientId("");
        mqttReceiveLog.setEnable(0);
        mqttReceiveLog.setCreateTime(new Date());
        mqttReceiveLog.setTopic(topic);
        mqttReceiveLog.setQos(String.valueOf(message.getQos()));
        mqttReceiveLog.setContent(new String(message.getPayload()));
        hzMqttReceiveLogService.insertHzMqttReceiveLog(mqttReceiveLog);
    }

}