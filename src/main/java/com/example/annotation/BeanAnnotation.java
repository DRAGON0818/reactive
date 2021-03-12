package com.example.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("donglxa")
@Scope
@Component
public class BeanAnnotation {

    public void say(String message){
        System.out.println("BeanAnnotation: "+ message );
    }
}
