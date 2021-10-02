package com.ruoyi.project.mqtt.util;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.enums.MqttStatus;
import com.ruoyi.common.enums.MqttType;
import com.ruoyi.common.enums.ServiceType;
import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.project.domain.HzMqttReceiveLog;
import com.ruoyi.project.service.IHzBankOrderService;
import com.ruoyi.project.service.IHzMqttReceiveLogService;
import com.ruoyi.project.vo.HzBankRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@Component
public class PushCallbackNew implements MqttCallback {

//    @Autowired
//    private MqttConfigNew mqttConfigNew;

//    @Autowired
//    private IHzMqttReceiveLogService hzMqttReceiveLogService;
//


    private IHzBankOrderService hzBankOrderService = BeanMQTTUtils.getBean(IHzBankOrderService.class);

    @Override
    public void connectionLost(Throwable cause) {        // 连接丢失后，一般在这里面进行重连
//        log.info("连接断开，正在重连");
//        MqttPushClientNew mqttPushClient = mqttConfigNew.getMqttPushClientNew();
//        if (null != mqttPushClient) {
//            mqttPushClient.connect(mqttConfigNew.getHost(), mqttConfigNew.getClientId(), mqttConfigNew.getUserName(),
//                    mqttConfigNew.getPassword(), mqttConfigNew.getTimeout(), mqttConfigNew.getKeepAlive());
//            log.info("已重连");
//        }

    }

    /**
     * 发送消息，消息到达后处理方法
     *
     * @param token
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    /**
     * 订阅主题接收到消息处理方法
     *
     * @param topic
     * @param message
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        // subscribe后得到的消息会执行到这里面,这里在控制台有输出
        log.info("new接收消息主题 : " + topic);
        log.info("new接收消息Qos : " + message.getQos());
        log.info("new接收消息内容 : " + new String(message.getPayload()));
        log.info("new接收信息：" + message.getId());
//        HzMqttReceiveLog mqttReceiveLog = new HzMqttReceiveLog();
//        mqttReceiveLog.setClientId("");
//        mqttReceiveLog.setEnable(0);
//        mqttReceiveLog.setCreateTime(new Date());
//        mqttReceiveLog.setTopic(topic);
//        mqttReceiveLog.setQos(String.valueOf(message.getQos()));
//        mqttReceiveLog.setContent(new String(message.getPayload()));
//        hzMqttReceiveLogService.insertHzMqttReceiveLog(mqttReceiveLog);
        HzBankRequestVO hzBankRequestVO = JSONObject.parseObject(new String(message.getPayload()), HzBankRequestVO.class);
        log.info("new接收信息class：" + hzBankRequestVO);
//        if (hzBankRequestVO == null || Objects.equals(MqttStatus.HZ_BANK_ERROR.getCode(), hzBankRequestVO.getStatus())){
//            new BaseException("project","mqtt消息不正确",null, hzBankRequestVO.toString());
//            return;
//        }

        if (ServiceType.HZ_SERVICE_CLIENT.getCode().equals(hzBankRequestVO.getService())) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Objects.equals(MqttType.HZ_BANK_RENT.getCode(), hzBankRequestVO.getType())) {//借出充电宝，生成订单
                        hzBankOrderService.insertOrder(hzBankRequestVO);
                    } else if (Objects.equals(MqttType.HZ_BANK_RETURN.getCode(), hzBankRequestVO.getType())) {//扫描二维码归还
                        hzBankOrderService.updateOrder(hzBankRequestVO);
                    } else if (Objects.equals(MqttType.HZ_BANK_GIVE_BACK.getCode(), hzBankRequestVO.getType())) {//点击"还" 归还充电宝
                        hzBankOrderService.updateOrderGiveBack(hzBankRequestVO);
                    }
                }

            }).start();
        }else{
            System.out.println("服务端 消息不接收：：：：：" + hzBankRequestVO);
        }
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "新线程创建了！");
//
//
//        }
//        ).start();

    }

}