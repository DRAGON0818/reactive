package com.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author whoami
 */
public class AopTest {
    private ClassPathXmlApplicationContext applicationContext;
    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");
        applicationContext.start();
        System.out.println("init");
    }

    @After
    public void close(){
        applicationContext.close();
        System.out.println("destroy");
    }

    @Test
    public void AopInTest() throws RuntimeException {
        MoocAspect moocAspect = applicationContext.getBean("moocAspect", MoocAspect.class);
        System.out.println(moocAspect.getClass().getName());
        AspectBiz aspectBiz = applicationContext.getBean("aspectBiz", AspectBiz.class);
        System.out.println(aspectBiz.getClass().getName());
        aspectBiz.aspectBiz();
    }

    @Test
    public void aopTestAround() {
        AspectBiz aspectBiz = applicationContext.getBean("aspectBiz", AspectBiz.class);
        aspectBiz.init("moocService",3);
    }

    /**
     * Introductions
     * 简介允许一个切面声明一个实现指定接口的通知对象，并且提供了一个接口实现类来代表这些对象。
     * 有<aop:aspect>中的<aop:declare-parents>元素声明该元素用户声明所匹配的类型拥有一个新的parent
     * 所有基于配置文件的<node>aspect</node> 只支持单例模式
     */
    @Test
    public void testFit() {
        Fit aspectBiz = applicationContext.getBean("aspectBiz",Fit.class);
        System.out.println(aspectBiz.getClass().getName());
        aspectBiz.filter();
    }
}
