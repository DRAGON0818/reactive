package com.aop.annotationAop;

import org.springframework.stereotype.Component;

/**
 * @author whoami
 */
@Component
public class TestController {

    @PermissionsAnnotation()
    public void PermissionsAnnotationTest(){
        System.out.println("测试程序");
    }
}
