package com.ruoyi.project.mqtt.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanMQTTUtils implements ApplicationContextAware {
    protected static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (BeanMQTTUtils.applicationContext == null) {
            BeanMQTTUtils.applicationContext = applicationContext;
        }
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    public static<T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

}
