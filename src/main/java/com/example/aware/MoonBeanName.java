package com.example.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author whoami
 */
public class MoonBeanName implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("moocBeanName : "+ s + " / hash code :" + this.hashCode());
    }
}
