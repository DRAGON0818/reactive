package com.example.Bean.CompoundProperties;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author whoami
 */
public class Bob implements DisposableBean {
    private String summary;
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSummary(){
        return summary;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean Bob is destroy");
    }
}
