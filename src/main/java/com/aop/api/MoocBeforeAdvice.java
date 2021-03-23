package com.aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author whoami
 */
public class MoocBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("MoocBeforeAdvice : "+ method.getName()+"  "
                + o.getClass().getName());
    }


}
