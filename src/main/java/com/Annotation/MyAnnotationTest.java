package com.Annotation;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author whoami
 */
public class MyAnnotationTest {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = MyAnnotationTest.class.getMethod("m");
        MyAnnotation annotation = (MyAnnotation) method.getAnnotation(MyAnnotation.class);
        String s = annotation.className();
        int value = annotation.value();
        System.out.println(s+value);
    }

    @MyAnnotation(className = "java,lang.String" , value=100)
    public static void m(){

    }
}
