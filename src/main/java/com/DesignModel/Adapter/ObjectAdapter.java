package com.DesignModel.Adapter;

public class ObjectAdapter implements Target{

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public Adaptee getAdaptee() {
        return adaptee;
    }

    public void setAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void show() {
        adaptee.specificRequest();
    }

    public static void main(String[] args) {
        ObjectAdapter objectAdapter = new ObjectAdapter(new Adaptee());
        objectAdapter.show();

    }
}
