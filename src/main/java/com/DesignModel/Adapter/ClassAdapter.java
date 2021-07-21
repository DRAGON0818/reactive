package com.DesignModel.Adapter;

/**
 * @author whoami
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void show() {
        specificRequest();
    }

    public static void main(String[] args) {
        Target target = new ClassAdapter();
        target.show();
    }
}
