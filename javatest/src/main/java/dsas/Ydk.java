package dsas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tdd on 2019/4/25.
 */

public class Ydk {

    protected static void getHTTP(String url){


        try {
            URL url1=new URL(url);
            HttpURLConnection coon=(HttpURLConnection) url1.openConnection();
            coon.setRequestMethod("POST");
            coon.setDoInput(true);
            coon.setDoOutput(true);
            coon.setRequestProperty("fdf","ff");
            coon.setConnectTimeout(5000);
            coon.setReadTimeout(30000);
            coon.connect();
            InputStreamReader input=new InputStreamReader(coon.getInputStream(),"UTF-8");
            BufferedReader bf=new BufferedReader(input);
            StringBuffer sb=new StringBuffer();
            String a=null;

            while ((a=bf.readLine())!=null){
                sb.append(a);
            }
            bf.close();
            input.close();
            coon.disconnect();
            System.out.println(sb.toString());
        }catch (Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args) {
        //Ydk.getHTTP("https://www.baidu.com");
        new Ydk().testd();
    }

    public void testd(){
        Long a=2l;
        Long b=a ^ 512;
        System.out.println(b);
        //System.out.println(a.SHA());
    }


}
