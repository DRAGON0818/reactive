package com.example.annotation.Bean;

/**
 * @author whoami
 */
public class StringStore implements Store{
    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }
}
