package com.ruoyi.project.config;

import com.ruoyi.project.domain.HzChargeDock;
import com.ruoyi.project.mqtt.util.MqttConfigNew;
import com.ruoyi.project.mqtt.util.MqttPushClientNew;
import com.ruoyi.project.service.IHzChargeDockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CoreBaseDataLoaderMqttClient implements ApplicationRunner {

    public static final Map<String,MqttPushClientNew> MQTT_PUSH_CLIENT_MAP = new HashMap<>();

    @Autowired
    private IHzChargeDockService hzChargeDockService;


    /**
     * 初始化加载标识
     */
    public static boolean isExecuted = false;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!isExecuted) {
            init();
            isExecuted = true;
        }
    }

    public void init() {

        //初始化mqtt客户端
        initMQTTClient();
    }

    private void initMQTTClient() {
        List<HzChargeDock> list = hzChargeDockService.getDockList();
        if (CollectionUtils.isEmpty(list)){
            return;
        }
        for (HzChargeDock chargeDock:list) {
            String codeUnique = chargeDock.getCodeUnique();
            MqttConfigNew mqttConfigNew = new MqttConfigNew();
            mqttConfigNew.setClientId(codeUnique);
            MqttPushClientNew mqttPushClientNew = mqttConfigNew.getMqttPushClientNew();
            MQTT_PUSH_CLIENT_MAP.put(codeUnique,mqttPushClientNew);
        }
        log.info("mqttClientMap:{}",MQTT_PUSH_CLIENT_MAP);
    }


}
