package com.aop.api;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author whoami
 */
public class MoocThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception exception) throws Throwable{
        System.out.println("MoocThrowsAdvice afterThrowing1");
    }

    public void afterThrowing(Method method, Object[] args,
                              Object target,Exception ex) throws Throwable{
        System.out.println("MoocThrowsAdvice afterThrowing2 :" + method.getName()
        +"     "+target.getClass().getName());
    }
}
