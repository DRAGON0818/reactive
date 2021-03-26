package com.Annotation;

import java.lang.annotation.Annotation;

/**
 * @author whoami
 */
public class ReflectTest {
    public static void main(String[] args) {
        getTypeAnnotation();
    }
    public static void getTypeAnnotation(){
        Class<SubClass> subClassClass = SubClass.class;
        Annotation[] annotations = subClassClass.getAnnotations();
        if (annotations.length > 0) {
            for (Annotation a : annotations) {
                System.out.println(a);
            }
        }
    }
}
