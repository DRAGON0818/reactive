package com.Annotation;

import java.lang.annotation.*;

/**
 * @author whoami
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

@Inherited
public @interface DbInfo {
    String tableName() default "emp";
}
