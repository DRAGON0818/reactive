package com.example.aware;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class AwareTest {
    private ClassPathXmlApplicationContext ac;
    public void before(){
        ac = new ClassPathXmlApplicationContext("spring-aware.xml");
        ac.start();
    }

    public void after(){
        ac.destroy();
    }
    @org.junit.Test
    public void test(){
        before();
        System.out.println("moocApplicationContext:" + ac.getBean("moocApplicationContext",MoocApplicationAware.class).hashCode());
        System.out.println("moocBeanName : "+ ac.getBean("moocBeanName",MoonBeanName.class).hashCode());
        after();
    }

    @org.junit.Test
    public void AwareTest(){
        before();
        System.out.println("AwareTest：" + ac.getBean("A",AwareClass.class).getName());
        after();
    }
}
