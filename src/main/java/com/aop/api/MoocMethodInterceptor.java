package com.aop.api;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author whoami
 */
public class MoocMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MoocMethodInterceptor:" + methodInvocation.getMethod().getName()+
                "   "+methodInvocation.getStaticPart().getClass().getName());
        Object ojb= methodInvocation.proceed();
        System.out.println("MoocMethodInterceptor : "+ ojb);
        return ojb;
    }
}
