package com.example.resource;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ResourceTest {

    private ClassPathXmlApplicationContext ac;
    public void before(){
        ac = new ClassPathXmlApplicationContext("spring-resource.xml");
        ac.start();
    }

    public void after(){
        ac.destroy();
    }

    @Test
    public void ResourceTest() throws IOException {
        before();
        MoocResource moocResource = ac.getBean("moocResource", MoocResource.class);
        moocResource.resource();
        after();
    }
}
