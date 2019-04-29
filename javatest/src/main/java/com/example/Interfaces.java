package com.example;

/**
 * Created by tdd on 2019/4/10.
 */

interface Interfaces {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interfaces {
    @Override
    public void doSomething() {
        // TODO Auto-generated method stub
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        // TODO Auto-generated method stub
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interfaces {
    // 保存委托类（父接口的引用）
    private Interfaces proxied;

    // 传入委托类的对象用于初始化
    public SimpleProxy(Interfaces proxied) {
        this.proxied = proxied;
    }

    // 两个同名方法中还实现了其他的功能
    @Override
    public void doSomething() {
        // TODO Auto-generated method stub
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        // TODO Auto-generated method stub
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}


