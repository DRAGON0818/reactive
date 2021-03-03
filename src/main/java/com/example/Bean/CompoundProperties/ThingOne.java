package com.example.Bean.CompoundProperties;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author whoami
 */
public class ThingOne {
    private Fred fred;
    public void setFred(Fred fred) {
        this.fred = fred;
    }
    public Fred getFred(){
        return fred;
    }
}
