package com.Decorator;

public class Pudding extends Decorator{

    private String description = "加了布丁";
    private MilkTea milkTea = null;

    public Pudding(MilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String getDescription() {
        return milkTea.getDescription() + " " + description;
    }

    @Override
    public double getPrice() {
        return milkTea.getPrice()+5;
    }
}
