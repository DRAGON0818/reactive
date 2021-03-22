package com.aop;

/**
 * @author whoami
 */
public class AspectBiz {
    public void aspectBiz() throws RuntimeException {
        System.out.println("AspectBiz!");
        //throw new RuntimeException();
    }

    public void init(String bizName, int times) {
        System.out.println("AspectZip init : " + bizName + " " + times);
    }
}
