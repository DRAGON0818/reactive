package com.aop.annotationAop;

import org.springframework.stereotype.Component;

/**
 * @author whoami
 */
@Component("targetClass")
public class TargetClass {
    public void t(){
        System.out.println("TargetClass : "+ this.getClass().getName());
    }
}
