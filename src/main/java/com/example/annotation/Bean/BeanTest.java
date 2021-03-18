package com.example.annotation.Bean;

import com.example.annotation.Resource.JsrService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class BeanTest {
    @Test
    public void BeanTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotation.xml");
       /* Store store = applicationContext.getBean("stringStore", Store.class);
        System.out.println(store.getClass().getName());
        Store store1 = applicationContext.getBean("integerStore", Store.class);
        System.out.println(store1.getClass().getName());*/


        MyDriverManager donglx = applicationContext.getBean("getTest", MyDriverManager.class);

//        MyDriverManager myDriverManager = applicationContext.getBean("myDriverManager", MyDriverManager.class);
//        System.out.println(myDriverManager.getClass().getName());

        JsrService jsrService = applicationContext.getBean("jsrService", JsrService.class);
        jsrService.save();
        applicationContext.close();

    }
}
