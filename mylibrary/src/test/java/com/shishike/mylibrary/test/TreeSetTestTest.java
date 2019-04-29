package com.shishike.mylibrary.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tdd on 2018/12/29.
 */
public class TreeSetTestTest {
    int a;
    int b;
    @Before
    public void setUp() throws Exception {
        System.out.println("刚开始");
        a=5;
        b=6;



    }

    @After
    public void tearDown() throws Exception {
        System.out.println("已结束");


    }

    @Test
    public void add() throws Exception {
        assertEquals(11,a+b);
        System.out.println(a+"加"+b+"=11没毛病");


    }

}