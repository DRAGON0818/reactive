package com.example.reactive;

import com.example.Bean.BasicDataSource;
import com.example.Bean.CompoundProperties.ThingOne;
import com.example.Bean.ExampleBean;
import com.example.service.ClientService;
import com.example.service.PetStoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * @author whoami
 */
public class TestApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("daos.xml", "services.xml");
        PetStoreService petStoreService = applicationContext.getBean("p", PetStoreService.class);
        System.out.println(petStoreService.toString());
        PetStoreService p=applicationContext.getBean("petStore",PetStoreService.class);
        System.out.println(p.toString());
        petStoreService.printTestResult();
        p.printTestResult();

        ClientService clientService = applicationContext.getBean("clientService", ClientService.class);
        System.out.println(clientService.toString());

        ExampleBean exampleBean = applicationContext.getBean("exampleId1", ExampleBean.class);
        System.out.println(exampleBean.toString());

        ExampleBean exampleBean1 = applicationContext.getBean("exampleId2", ExampleBean.class);
        System.out.println(exampleBean1.toString());

        PropertySourcesPlaceholderConfigurer mappings = applicationContext.getBean("mappings", PropertySourcesPlaceholderConfigurer.class);
        System.out.println(mappings.toString());

        BasicDataSource myDataSource = applicationContext.getBean("myDataSource", BasicDataSource.class);
        System.out.println(myDataSource.getPassword());
        myDataSource.close();

        BasicDataSource dataSource1 = applicationContext.getBean("dataSource_one", BasicDataSource.class);
        System.out.println(dataSource1.toString());


        /** test for (1.4.2) 'Compound Property Names'**/

        ThingOne something = applicationContext.getBean("something", ThingOne.class);
        System.out.println(something.getFred().getBob().getSummary());

        applicationContext.registerShutdownHook();
    }
}
