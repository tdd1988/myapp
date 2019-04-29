package com.example;

/**
 * Created by tdd on 2019/4/3.
 */

public class Tes {
    public static void main(String[] args) {
        new TestA(new Jiekou() {
            @Override
            public void testJ(String a) {
                System.out.println(a);
            }
        });
    }

}
