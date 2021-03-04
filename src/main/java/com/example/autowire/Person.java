package com.example.autowire;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author whoami
 */
public class Person {
    @Autowired
    private Cat cat;
    private String say;

    public Person(){

    }

    public Person(Cat cat,String say)
    {
        this.cat=cat;
        this.say=say;
    }
    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", say='" + say + '\'' +
                '}';
    }
}
