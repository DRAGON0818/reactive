package com.example.annotation.Bean;

/**
 * @author whoami
 */
public interface Store<T> {
    default public void init(){
        System.out.println("init");
    }

    default public void destroy(){
        System.out.println("destroy");
    }
}
