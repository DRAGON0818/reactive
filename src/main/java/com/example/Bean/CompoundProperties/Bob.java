package com.example.Bean.CompoundProperties;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author whoami
 */
public class Bob {
    private String summary;
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSummary(){
        return summary;
    }
}
