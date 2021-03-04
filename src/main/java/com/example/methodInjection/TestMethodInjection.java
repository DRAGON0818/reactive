package com.example.methodInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class TestMethodInjection {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-methodInjection.xml");
        for(int i =0 ; i <= 5 ;i++){
            UserService userService = applicationContext.getBean("userService", UserService.class);
            userService.login("root", "root");
        }
    }
}
