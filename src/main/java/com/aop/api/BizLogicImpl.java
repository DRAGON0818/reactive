package com.aop.api;

/**
 * @author whoami
 */
public class BizLogicImpl implements BizLogic {

    @Override
    public String save() {
        System.out.println("BizLogicImpl");
        return "Logic";
    }
}
