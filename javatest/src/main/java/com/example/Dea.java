package com.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by tdd on 2019/4/10.
 */

public class Dea {
    public static void main(String[] args) {
        Integer[] A = new Integer[] {7864, 284, 347, 7732, 8498};
        Arrays.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {


                return (o2+"").compareTo(o1+"");
            }

        });
        System.out.println(Arrays.toString(A));






    }
}
