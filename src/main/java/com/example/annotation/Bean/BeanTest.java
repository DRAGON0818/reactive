package com.example.annotation.Bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class BeanTest {
    @Test
    public void BeanTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
        Store store = applicationContext.getBean("stringStore", Store.class);
        System.out.println(store.getClass().getName());
        applicationContext.close();
    }
}
