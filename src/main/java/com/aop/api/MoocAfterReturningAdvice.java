package com.aop.api;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author whoami
 */
public class MoocAfterReturningAdvice  implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("MoocAfterReturningAdvice : "+method.getName()
        +"    "+o.getClass().getName());
    }
}
