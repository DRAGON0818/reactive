package com.example.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author whoami
 */
public class MoocApplicationAware implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("moocApplicationContext:" + applicationContext.getBean("moocApplicationContext",MoocApplicationAware.class).hashCode());
    }
}
