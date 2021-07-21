package com.Ext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author whoami
 */
@Configuration
@ComponentScan(value = "com.Ext")
public class MyConfiguration {

    public MyConfiguration(){
        System.out.println("MyConfiguration was created  ");
    }

//    @Value(value = "donglxa")
//    @Bean
//    public User user(String name){
//        return new User(name);
//    }
//
//    @Value(value = "zj")
//    @Bean
//    public User user1(String name){
//        return new User(name);
//    }

    @Bean
    public PersonFactoryBean personFactoryBean(){
        PersonFactoryBean personFactoryBean = new PersonFactoryBean();
        personFactoryBean.setInitStr("donglxa");
        return personFactoryBean;
    }

}
