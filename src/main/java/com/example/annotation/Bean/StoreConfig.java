package com.example.annotation.Bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

/**
 * @Configuration 相当于这个类是一个配置文件XML,IOC容器会自动扫描
 * @author whoami
 */
@Configuration
public class StoreConfig {
    private String url;
    private String username;
    private String password;

    /**
     * @Bean 默认的是会创建一个方法名的bean对象
     * 可以@Bean(name = "" ) 指定ID
     * 也可以在里面指定initMethod/destroy-method ,  方法具体在"实现类"中定义。
     * 以下相当于<bean id="stringStore" class="com.example.annotation.Bean.StoreStore"><bean/>
     * @return
     */
    @Scope("singleton")
    @Bean(name = "stringStore" , initMethod = "init" ,destroyMethod = "destroy")
    public Store getStringStore(){
        return new StringStore();
    }

}
