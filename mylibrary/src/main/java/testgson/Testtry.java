package testgson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by tdd on 2019/1/15.
 */

public class Testtry {

    public static void main(String[] args) {
        try {
            FileInputStream ins=new FileInputStream("/Users/tdd/Desktop/tdd.txt");

            FileOutputStream fos =new FileOutputStream("/Users/tdd/Desktop/tdd2.txt");
            OutputStreamWriter fir =new OutputStreamWriter(fos,"UTF-8");
            byte[] buf = new byte[6];
            int b=0;
            //while ((s=bfreader.readLine() )!=null){fir.write(s);System.out.println(s);}
            while((b=ins.read(buf))!=-1){
                fos.write(buf,0,6);
            }
             //fir.write(s);
            fos.flush();
            fos.close();

        }catch (Exception E){

        }

    }
}
