package com.Ext;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements InitializingBean , DisposableBean {
    String name;

    public void init(){
        System.out.println("init");
    }

    public User() {
        System.out.println("User init");
    }

    public User(String name) {
        System.out.println("this's name " + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }

    @PostConstruct
    public void postConstructMethod(){
        System.out.println("postConstructMethod");
    }
    @PreDestroy
    public void preDestroyMethod(){
        System.out.println("preDestroyMethod");
    }
}
