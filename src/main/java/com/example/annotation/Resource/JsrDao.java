package com.example.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * @author whoami
 */
@Repository
public class JsrDao {

    public void save(){
        System.out.println("JsrDao invoked!");
    }
}
