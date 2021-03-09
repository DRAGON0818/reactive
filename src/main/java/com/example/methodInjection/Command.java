package com.example.methodInjection;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author whoami
 */
public class Command implements  DisposableBean {
    private Object state;
    public Command(){
        System.out.println("Class " + this.getClass() + " was created!");
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Object execute(){
        return state+ "  of " + this.getClass();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy Command bean!");
    }

    public void init(){
        System.out.println("Bean Init");
    }
}
