package com.example.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author whoami
 */
public class AwareClass implements ApplicationContextAware, BeanNameAware {
    /** aware有让....意识到 的意思，所以继承了ApplicationContextAware接口的类，可以通过setApplicationContext方法，自动获得上下文。
     *
     * 而BeanNameAware接口，能够将bean对象的ID传入到setBeanName中。（也就是在构造器后，调用set方法完成注入）
     * @attribute name 用于存储传进来的参数
     * **/
    private String name;

    @Override
    public void setBeanName(String s) {
        this.name=s;
        System.out.println("****************moocBeanName : "+ s + " / hash code :" + this.hashCode());
    }

    public String getName() {
        return name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext : " + applicationContext.getBean("A",AwareClass.class).hashCode());
    }
}
