package com.example;

/**
 * Created by tdd on 2019/4/10.
 */


public class Ads {

    public static void main(String[] args) {
        consumer(new RealObject());
        //consumer(new SimpleProxy(new RealObject()));
    }

    public static void consumer(Interfaces iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
}

