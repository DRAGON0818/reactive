package com.example.autowire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class TestAutowire {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_autowire.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person.getCat().toString());
        person.getCat().sayCat();

        Person person1 = applicationContext.getBean("person1", Person.class);
        System.out.println(person1.toString()+" ");
    }
}
