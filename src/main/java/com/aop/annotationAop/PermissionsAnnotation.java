package com.aop.annotationAop;

import java.lang.annotation.*;

/**
 * @author whoami
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionsAnnotation {
}
