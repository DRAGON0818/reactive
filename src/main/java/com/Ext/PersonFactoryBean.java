package com.Ext;

import com.example.autowire.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author whoami
 */
//@Component
public class PersonFactoryBean implements FactoryBean<Person> {

    private String initStr;

    public String getInitStr() {
        return initStr;
    }

    public void setInitStr(String initStr) {
        this.initStr = initStr;
    }

    @Override
    public Person getObject() throws Exception {
        Objects.requireNonNull(initStr);
        String[] split = initStr.split(",");
        Person person = new Person();
        person.setSay("toString");
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
