package dsas;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tdd on 2019/4/24.
 */

public class Tsl {
    public static void main(String[] args) throws IOException{
        //new Tsl().tes();
        Process ps= Runtime.getRuntime().exec("adb devices");
        StringBuffer sb=new StringBuffer();
        BufferedReader bf=new BufferedReader(new InputStreamReader(ps.getInputStream()));
        String a;

        while((a=bf.readLine())!=null){
            sb.append(a);
        }
        System.out.println(sb);

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
        System.out.println("我是dev创建的2");


    }

        }
