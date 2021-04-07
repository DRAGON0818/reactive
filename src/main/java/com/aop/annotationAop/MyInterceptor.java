package com.aop.annotationAop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author whoami
 */
@Component
@Aspect
public class MyInterceptor {

    @Pointcut("execution (* com.aop.annotationAop.*.*(..))")
    private void anyMethod() {} // 声明一个切入点，anyMethod为切入点名称

    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知");
    }

}
