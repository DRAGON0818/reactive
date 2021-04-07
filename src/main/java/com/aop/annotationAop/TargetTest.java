package com.aop.annotationAop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class TargetTest {
    @Test
    public void t(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
        applicationContext.start();
        //TargetClass targetClass = applicationContext.getBean("targetClass", TargetClass.class);
        //targetClass.t();
        TestController testController = applicationContext.getBean("testController", TestController.class);
        testController.PermissionsAnnotationTest();
        applicationContext.close();
    }
}
