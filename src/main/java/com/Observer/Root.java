package com.Observer;

import reactor.core.publisher.Flux;

import java.util.Observable;
import java.util.Observer;

/**
 * @author whoami
 */
public class Root {
    public static void main(String[] args) {

        Flux<Integer> just = Flux.just(1, 2, 4, 5);
        just.subscribe(System.out::println);

        House h = new House(10000);
        HousePriceObserver hp1 = new HousePriceObserver("购房者A");
        HousePriceObserver hp2 = new HousePriceObserver("购房者B");
        HousePriceObserver hp3 = new HousePriceObserver("购房者C");
        h.addObserver(hp1);
        h.addObserver(hp2);
        h.addObserver(hp3);
        System.out.println(h);
        h.setPrice(66666);
        System.out.println(h);
    }

}

class House extends Observable{
    private float price;

    public House(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        super.setChanged();
        super.notifyObservers(price);
        this.price = price;
    }

    @Override
    public String toString() {
        return "House{" +
                "price=" + price +
                '}';
    }
}

class HousePriceObserver implements Observer{
    private String name;

    public HousePriceObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Float) {
            System.out.println(this.name+ " 观察到价格更改为: "+((Float)arg).floatValue());
        }
    }
}
