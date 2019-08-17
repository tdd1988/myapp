package com.example;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

/**
 * Created by tdd on 2019/4/9.
 */

public class TestIO {
    static String filePath="/Users/tdd/Desktop/javaIO流2.txt";
    public void getH() throws Exception{
        OutputStreamWriter ins=new OutputStreamWriter(new FileOutputStream(filePath,true));
        ins.write("中国");
        ins.flush();
        ins.close();
    }

    public static void testFile() throws Exception{
        FileWriter fl =new FileWriter(filePath,true);
        fl.write("哈哈");
        fl.flush();
        fl.close();
    }

    public static void main(String[] args)throws Exception {

    }


}
