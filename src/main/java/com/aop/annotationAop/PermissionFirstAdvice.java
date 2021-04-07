package com.aop.annotationAop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author whoami
 */
@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {
    @Pointcut("@annotation(com.aop.annotationAop.PermissionsAnnotation)")
    private void permissionCheck() {
    }

    @Before("permissionCheck()")
    public void permissionChechBefore(){
        System.out.println("before first");

    }

    @AfterReturning("permissionCheck()")
    public void permissionCheckFirst(){
        System.out.println("第一个切面");
    }
}
