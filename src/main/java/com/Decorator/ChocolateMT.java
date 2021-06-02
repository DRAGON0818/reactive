package com.Decorator;

public class ChocolateMT implements MilkTea{

    private final static String description = "巧克力奶茶";
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return 10;
    }
}
