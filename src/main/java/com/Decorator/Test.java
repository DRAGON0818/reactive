package com.Decorator;

public class Test {
    public static void main(String[] args) {
        MilkTea milkTea = new ChocolateMT();
        milkTea = new Pudding(milkTea);
        milkTea = new Cocount(milkTea);
        System.out.println(milkTea.getDescription() + "  " + milkTea.getPrice());
    }
}
