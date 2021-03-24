package com.aop.service;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

/**
 * @author whoami
 */
@Service("invoke")
public class InvokeService {
    public void invoke(){
        System.out.println("InvokeService!");
    }

    public void invokeException(){
        throw new PessimisticLockingFailureException("");
    }
}
