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
@Order(2)
public class PermissionSecondAdvice {

    @Pointcut("@annotation(com.aop.annotationAop.PermissionsAnnotation)")
    private void permissionCheck(){

    }

    @Before("permissionCheck()")
    public void permissionCheckBefore()
    {
        System.out.println("before second");
    }

    @AfterReturning("permissionCheck()")
    public void permissionCheckSecond(){
        System.out.println("第二个切面");
    }

}
