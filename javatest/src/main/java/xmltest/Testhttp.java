package xmltest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tdd on 2019/7/1.
 */

public class Testhttp {

    public static void main(String[] args)throws Exception {
        new Testhttp().tests();


    }

    public void tests() throws Exception {
        String urls="https://tm.tita.com/OAuth/Token";
        URL url=new URL(urls);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Mobile/14E304 NativeApp BeisenApp ITalent/2.0.1"); // 设置接收数据的格式
        connection.setRequestProperty("Accept-Language", "zh-Hans-CN;q=1, zh-Hant-CN;q=0.9, en-US;q=0.8"); // 设置发送数据的格式
        connection.addRequestProperty("Authorization",null);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.connect();
        StringBuffer sb = new StringBuffer();
        sb.append("valcode=null&valcode_key=null&app_id=100&grant_type=password&password=tdd1235&secret=16bd2f170d174be0aa58919568c113da&username=tiandongdong_cd@keruyun.com");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        osw.write(sb.toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String lines;
        StringBuffer sbs = new StringBuffer("");
        while ((lines = reader.readLine()) != null) {
            lines = new String(lines.getBytes(), "utf-8");
            sbs.append(lines);
        }
        reader.close();
        // 断开连接
        connection.disconnect();

        osw.flush();
        osw.close();
        System.out.println(sbs.length());




    }
}