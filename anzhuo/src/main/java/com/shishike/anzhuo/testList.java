package com.shishike.anzhuo;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tdd on 2019/4/2.
 */

public class testList {
    public void testdk(){
        Integer[] a_int = { 1, 2, 3, 4 };
        List a_int_List = Arrays.asList(a_int);
        a_int_List.set(0,5);
        //使用asList方法转换的列表不支持add和remove方法；
        //a_int_List.add(6);
        for (Object a:a_int_List
             ) {
            System.out.println((int)a);
        }
        System.out.println(a_int[0]);
    }

    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        try {
            //string
            object.put("string","string");
            //int
            object.put("int",2);
            //boolean
            object.put("boolean",true);
            //array
            List<Integer> integers = Arrays.asList(1,2,3);
            object.put("list",integers);
            //null
            System.out.println(object);

        }catch (JSONException E){

        }


    }
}
