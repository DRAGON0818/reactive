package com.example.Dao;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author whoami
 */
public class JpaItemDao implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("JpaItemDao is destroy");
    }
}
