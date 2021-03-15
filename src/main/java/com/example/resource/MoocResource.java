package com.example.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author whoami
 */
public class MoocResource implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public void resource() throws IOException {
        Resource resource = applicationContext.getResource("daos.xml");
        System.out.println(resource.getFilename());
        System.out.println(resource.contentLength());
    }
}
