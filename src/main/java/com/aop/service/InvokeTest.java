package com.aop.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class InvokeTest {
    private ClassPathXmlApplicationContext applicationContext;
    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        applicationContext.start();
        System.out.println("init");
    }

    @After
    public void close(){
        applicationContext.close();
        System.out.println("destroy");
    }

    @Test
    public void testSave(){
        InvokeService invokeService = applicationContext.getBean("invoke", InvokeService.class);
        invokeService.invoke();

        System.out.println("____________________________");
        invokeService.invokeException();
    }
}
