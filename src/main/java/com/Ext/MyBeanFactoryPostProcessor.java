package com.Ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.stereotype.Component;

/**
 * @author whoami
 */
//@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition user = configurableListableBeanFactory.getBeanDefinition("user");
        user.setInitMethodName("init");
        System.out.println("postProcessBeanFactory : " + configurableListableBeanFactory.getBeanDefinitionCount());

    }
}
