package com.example.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;
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
@ImportResource("config.xml")
public class StoreConfig {

    @Autowired
    private Store<String> s1;
    @Autowired
    private Store<Integer> s2;
//    @Value("${url}")
//    private String url;
//    @Value("${username}")
//    private String username;
//    @Value("${password}")
//    private String password;

    /**
     * @Bean 默认的是会创建一个方法名的bean对象
     * 可以@Bean(name = "" ) 指定ID
     * 也可以在里面指定initMethod/destroy-method ,  方法具体在"实现类"中定义。
     * 以下相当于<bean id="stringStore" class="com.example.annotation.Bean.StoreStore"><bean/>
     * @return
     */
    @Scope("prototype")
    //@Bean(name = "stringStore" , initMethod = "init" ,destroyMethod = "destroy")
    @Bean
    public StringStore getStringStore(){
        return new StringStore();
    }

    @Scope(value = "prototype")
    @Bean
    //@Bean(name = "integerStore", initMethod = "init" , destroyMethod = "destroy")
    public IntegerStore getIntegerStore() {
        return new IntegerStore();
    }


    @Bean
    public MyDriverManager getTest(){
        System.out.println(s1.getClass().getName());
        System.out.println(s2.getClass().getName());
        return new MyDriverManager();
    }

//    @Bean
//    public MyDriverManager myDriverManager(){
//        return new MyDriverManager(url, username, password);
//    }

}
