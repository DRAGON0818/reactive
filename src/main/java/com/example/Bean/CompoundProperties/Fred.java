package com.example.Bean.CompoundProperties;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author whoami
 */
public class Fred {
    private Bob bob;
    public void setBob(Bob bob) {
        this.bob = bob;
    }

    public Bob getBob(){
        return bob;
    }
}
