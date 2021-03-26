package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 说明注解所修饰的对象范围，取值在ElementType的枚举中。
 * @Retention 定义Annotation被保留的时间长短，取值在RetentionPolicy的枚举中，源文件保留/class保留/运行时保留
 *
 * @author whoami
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
    /**
     * 注解，其中的每一个方法实际上是声明了一个配置参数。方法的名称就是参数的名称
     * @return
     */
    String className() default "dong";
    int value() default 1000;
}
