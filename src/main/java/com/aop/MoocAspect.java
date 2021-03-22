package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author whoami
 */
public class MoocAspect {
    public void before(){
        System.out.println("***************************************************");
        System.out.println("moocAspect!");
    }

    public void afterReturning(){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("After Returning!");
    }

    public void afterThrowing(){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("MoocAspect afterThrowing!");
    }
    public void after(){
        System.out.println("MoocAspect After!");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object ojb = null;
        try {
            System.out.println("MoocAspect around 1");
            ojb = proceedingJoinPoint.proceed();
            System.out.println("MoocAspect around 2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ojb;
    }

    public Object aroundInit(ProceedingJoinPoint proceedingJoinPoint, String bizName, int times) {
        Object ojb = null;
        try {
            System.out.println(bizName + "," + times);
            System.out.println("MoocAspect around 1");
            ojb = proceedingJoinPoint.proceed();
            System.out.println("MoocAspect around 2");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ojb;
    }
}
