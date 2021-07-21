package com.DesignModel.Decorator;

public class TeaDecorator implements Tea {
    private Tea tea;
    public TeaDecorator(Tea tea) {
        this.tea = tea;
    }
    @Override
    public void Tea() {
        tea.Tea();
        this.addFunction();
    }
    public void addFunction(){
        System.out.println("不违背开闭原则的前提下，增加了功能。缺点是会增加许多的子类。");
    }
}
