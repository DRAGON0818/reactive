package com.example.annotation.Resource;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author whoami
 */
@Service
public class JsrService {
    @Resource
    private JsrDao jsrDao;

    @Resource
    public void setJsrDao(JsrDao jsrDao) {
        this.jsrDao = jsrDao;
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy");
    }

    public void save(){
        jsrDao.save();
    }
}
