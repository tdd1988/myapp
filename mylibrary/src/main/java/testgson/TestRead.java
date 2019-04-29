package testgson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by tdd on 2019/1/7.
 */

public class TestRead {


    public static void testZifu() throws IOException{
        FileInputStream fis = new FileInputStream("/Users/tdd/Downloads/alipay_record_20190403_1025_1.csv");
        InputStreamReader isr = new InputStreamReader(fis,"GB18030");
        FileOutputStream fos = new FileOutputStream("/Users/tdd/Desktop/tdd9.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        int s;
        char[] bytes=new char[1024];
        while((s = isr.read(bytes,0,bytes.length)) != -1) {
            osw.write(bytes,0,s);
            fos.flush();
            osw.flush();
        }
        fis.close();
        fos.close();
        System.out.println("写入完成！");
    }

    public static void testByte() throws IOException{
        FileInputStream fis = new FileInputStream("/Users/tdd/Desktop/WechatIMG94.jpeg");
        FileOutputStream fos = new FileOutputStream("/Users/tdd/Desktop/知识.jpeg");

        byte[] bytes=new byte[1024];

        int s;
        while((s = fis.read(bytes,0,bytes.length)) != -1) {
            fos.write(bytes,0,s);
            fos.flush();
        }
        fis.close();
        fos.close();
        System.out.println("写入完成！");
    }



    public static void main(String[] args) throws IOException {

        TestRead.testZifu();
    }


    public static void testce() throws IOException{
        File fl=new File("/Users/tdd/Desktop/javaIO流.txt");
        if(!fl.exists()){
            fl.createNewFile();
        }
        FileInputStream fs=new FileInputStream(fl);
        int b;
        byte[] bytes=new byte[1024];

        FileOutputStream fos =new FileOutputStream("/Users/tdd/Desktop/javaIO流2.txt");
        while ((b=fs.read(bytes))!=-1){
            fos.write(bytes);
        }


    }
}


