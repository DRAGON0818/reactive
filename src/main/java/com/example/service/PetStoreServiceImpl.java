package com.example.service;

import com.example.Dao.JpaAccountDao;
import com.example.Dao.JpaItemDao;

/**
 * @author whoami
 */
public class PetStoreServiceImpl implements PetStoreService{

    private JpaAccountDao jpaAccountDao;
    private JpaItemDao jpaItemDao;

    public void setJpaAccountDao(JpaAccountDao jpaAccountDao) {
        this.jpaAccountDao = jpaAccountDao;
    }

    public void setJpaItemDao(JpaItemDao jpaItemDao) {
        this.jpaItemDao = jpaItemDao;
    }

    @Override
    public void printTestResult() {
        System.out.println("基于配置文件XML的spring最基础程序");
    }
}
