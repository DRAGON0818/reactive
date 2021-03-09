package com.example.methodInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author whoami
 */
public class TestMethodInjection {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-methodInjection.xml");
        for(int i =0 ; i < 1 ;i++){
            UserService userService = applicationContext.getBean("userService", UserService.class);
            userService.login("root", "root");
        }

        /** 虽然CommandManager是抽象类， 会通过CGLIB字节码动态创建子类。   如com.example.methodInjection.CommandManager$$EnhancerBySpringCGL$$1@20b25f  **/
        CommandManager commandManager = applicationContext.getBean("commandManager", CommandManager.class);
        System.out.println(commandManager.toString());
        System.out.println(commandManager.process("command"));
        System.out.println(commandManager.myProcess("myCommand"));


        MyValueCalculator myCalculator = applicationContext.getBean("myCalculator", MyValueCalculator.class);
        System.out.println(myCalculator.computeValue("True"));
        applicationContext.registerShutdownHook();
    }
}
