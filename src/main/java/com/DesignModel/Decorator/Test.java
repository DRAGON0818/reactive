package com.DesignModel.Decorator;

public class Test {
    public static void main(String[] args) {
        TeaDecorator teaDecorator = new TeaDecorator(new LongTea());
        teaDecorator.Tea();

    }
}
