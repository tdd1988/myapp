package com.shishike.mylibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by tdd on 2019/1/15.
 *
 * public static void main(String[] args) {
 //throws ClassNotFoundException,IOException
 try {
 //FileReader fl= new FileReader("/Users/tdd/Desktop/新建文本文档4.txt");
 FileInputStream fi= new FileInputStream("/Users/tdd/Desktop/新建文本文档4.txt");
 FileOutputStream fw= new FileOutputStream("/Users/tdd/Desktop/tdds/新建文本文档5.txt");
 int i;
 while((i=fi.read())!=-1){
 fw.write(i);
 }

 fw.flush();
 fw.close();
 fi.close();
 }
 catch (IOException e){
 System.out.println("meizhaodao");
 }
 System.out.println("最后一个");

 }
 */

public class TestIO {

    public void testss() throws ClassNotFoundException,IOException {
        FileInputStream fi = new FileInputStream("/Users/tdd/Desktop/新建文本文档4.txt");
        FileOutputStream fw = new FileOutputStream("/Users/tdd/Desktop/tdds/新建文本文档5.txt");
        int i;
        while ((i = fi.read()) != -1) {
            fw.write(i);
        }
        fw.flush();
        fw.close();
        fi.close();
    }

    public void testy(){
        try{
            testss();

        }catch (ClassNotFoundException E){

        }catch (IOException E){

        }
    }



}
