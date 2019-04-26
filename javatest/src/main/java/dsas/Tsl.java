package dsas;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tdd on 2019/4/24.
 */

public class Tsl {
    public static void main(String[] args) throws IOException{
        new Tsl().tes();

    }

    public void tes() throws IOException{
        Process process =Runtime.getRuntime().exec("ifconfig");
        //System.out.println(process.);
        //BufferedInputStream bf=new BufferedInputStream(process.getInputStream());
        InputStreamReader inr =new InputStreamReader(process.getInputStream());

        char[] ch=new char[1024*50];
        inr.read(ch);
        System.out.println(new String(ch,0,ch.length));
        inr.close();
        System.out.println("我是dev创建的");

        }




}
