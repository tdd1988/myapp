package com.example;

/**
 * Created by tdd on 2019/4/3.
 */

public class TestA {
    protected Jiekou mjiekou;
    public TestA(Jiekou jiekou){
        mjiekou=jiekou;
        testb();
    }

    public void testb(){
        String a="tdd";
        mjiekou.testJ(a);
    }


}
