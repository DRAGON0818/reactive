package com.example.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class AnnotationTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
//        BeanAnnotation beanAnnotation = applicationContext.getBean("beanAnnotation", BeanAnnotation.class);
//        beanAnnotation.say("S");
//
//        BeanAnnotation beanAnnotation1 = applicationContext.getBean("beanAnnotation", BeanAnnotation.class);
//        System.out.println(beanAnnotation1.hashCode()+","+beanAnnotation.hashCode());

        BeanInvoker beanInvoker = applicationContext.getBean("beanInvoker", BeanInvoker.class);
        beanInvoker.say();

    }
}
