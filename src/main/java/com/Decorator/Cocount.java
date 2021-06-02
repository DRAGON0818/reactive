package com.Decorator;

public class Cocount extends Decorator{
    private String description = "加了椰果";
    private MilkTea milkTea = null;

    public Cocount(MilkTea milkTea) {
        this.milkTea=milkTea;
    }

    @Override
    public String getDescription() {
        return milkTea.getDescription() + " " + description;
    }

    @Override
    public double getPrice() {
        return milkTea.getPrice() + 3;
    }
}
