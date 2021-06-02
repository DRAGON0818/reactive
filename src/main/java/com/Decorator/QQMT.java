package com.Decorator;

public class QQMT implements MilkTea{
    private final static String description = "QQ奶茶";
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 15;
    }
}
