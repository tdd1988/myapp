package testgson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.shishike.mylibrary.BuildConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by tdd on 2019/1/3.
 */

public class TestGsons {
    public static void main(String[] args ){
        String str;
        Gson gson = new Gson();
        TreeMap returnInventoryItemsMap = new TreeMap();
        returnInventoryItemsMap.put("amount","1");
        returnInventoryItemsMap.put("price","10");
        returnInventoryItemsMap.put("quantity","100");
        returnInventoryItemsMap.put("skuName","1000");
        returnInventoryItemsMap.put("skuUuid","10000");

        //Iterator tm = returnInventoryItemsMap.keySet().iterator();
        //while(tm.hasNext()){System.out.println(returnInventoryItemsMap.get(tm.next()));}

        Iterator tm = returnInventoryItemsMap.entrySet().iterator();
        Map.Entry[] li=new Map.Entry[5];
          while (tm.hasNext()) {
           // entry的输出结果如key0=value0等
           Map.Entry entry =(Map.Entry) tm.next();
           Object key = entry.getKey();
           Object value=entry.getValue();
           System.out.println(entry);
              ArrayList<Map.Entry> al= new ArrayList<Map.Entry>();
              al.add(entry);
           //System.out.println(key);
           //System.out.println(value);

              int i=0;li.toString();
              i++;
              li[i]=entry;
          }



        String STR2=returnInventoryItemsMap.toString();

        JsonElement returnInventoryItems1 = gson.toJsonTree(returnInventoryItemsMap);
        String STR3=gson.toJson(returnInventoryItemsMap);
        String STR1=returnInventoryItems1.toString();
        JsonArray returnInventoryItems = new JsonArray();
        returnInventoryItems.add(returnInventoryItems1);
        str=returnInventoryItems.toString();
        System.out.println(str);
        System.out.println(STR1);
        System.out.println(STR2);
        System.out.println(STR3);



    }


}
