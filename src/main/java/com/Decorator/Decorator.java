package com.Decorator;

public class Decorator implements MilkTea{

    private final static String description = "我只是一个装饰器，不知道是那个奶茶";
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
