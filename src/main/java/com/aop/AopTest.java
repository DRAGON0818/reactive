package com.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class AopTest {
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
    public void AopInTest(){
//        MoocAspect moocAspect = applicationContext.getBean("moocAspect", MoocAspect.class);
//        System.out.println(moocAspect.getClass().getName());
        AspectBiz aspectBiz = applicationContext.getBean("aspectBiz", AspectBiz.class);
        System.out.println(aspectBiz.getClass().getName());
        aspectBiz.aspectBiz();
    }
}
