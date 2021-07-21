package com.Ext;

import com.example.autowire.Person;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author whoami
 */
public class ExtTest {

    static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args){
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
//        User user = annotationConfigApplicationContext.getBean("user", User.class);
//        System.out.println(user.toString());
//        User user1 = annotationConfigApplicationContext.getBean("user1", User.class);
//        System.out.println(user1.toString());
//        annotationConfigApplicationContext.close();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
              t();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                t();
            }
        });
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Person personFactoryBean = beanFactory.getBean("personFactoryBean", Person.class);
        System.out.println(personFactoryBean.toString());

    }

    public static void t(){
        for(int i =0 ;i<10;i++) {
            lock.lock();
            try {
                Thread.sleep(100000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }
}
