package com.shishike.anzhuo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tdd on 2019/4/1.
 */

public class Testbi {

    public void testH(View view,String pathname) throws Exception{
     view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bs= view.getDrawingCache();
        try {
            File fl= new File("DSFD.jpg");
            if (!fl.exists()){
                fl.createNewFile();
            }
            FileOutputStream fileOutputStream=new FileOutputStream(fl);
            bs.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            fileOutputStream.close();
        }catch (Exception E){}
        view.setDrawingCacheEnabled(false);

    }
    public static void main(String[] args) {

        System.out.println(httptE());

    }

    public static String httptE(){
        HttpURLConnection connection=null;
        String resp=null;
        BufferedReader bf=null;
        InputStream stream=null;

        try {
            URL url=new URL("https://www.baidu.com");
            connection=(HttpURLConnection)url.openConnection();
            HttpClient htt=new DefaultHttpClient();
            connection.setRequestMethod("get");
            connection.setConnectTimeout(5000);
            connection.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
            connection.setRequestProperty("Cookie","BAIDUID=3E824A853BDF105456C60EF5C7682B7A:FG=1; BIDUPSID=3E824A853BDF105456C60EF5C7682B7A; PSTM=1545188469; BD_UPN=123253; BDUSS=WNvbk9VZmJuYlNWS0xSdlViNH5pVzVFenlrZTd5ekhBNGZMZU4yOGJJWlpCRzFjQVFBQUFBJCQAAAAAAAAAAAEAAACzCnUVNjAxMjYwNTM3AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFl3RVxZd0Vcc; ispeed_lsm=2; H_PS_PSSID=1459_21103_28767_28724_28558_28697_28585_28604_28626_28606; MCITY=-75%3A; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDSFRCVID=Er_sJeCCxG3t06c9CuMJtJtJwkCH6AQX2liC3J; H_BDCLCKID_SF=tbkD_C-MfIvhDRTvhCcjh-FSMgTBKI62aKDsKqFE-hcqEpO9QTbkMjFqeqJ9X4rZaa8qLnvnWIQNVfP4h-rTDUThDNtDt60jfn3tWJTOaj6jDbTnMIT8bKCShUFsKIuL-2Q-5hOy3KOkjDTFeJJcXh-JKh7fKjOmWncCbxP-anTThpFuDTtajj3QeaRt2tcyatj2WnTJ25r8e5rnhPF35tKdKP6-3MJO3b7ZBCT_f435HRQNhhJjqtPdyajCQlkHaI5mohFLtCtbMD_mj6A35n-Wqxc0etJyaR3z_4bbWJ5TEPnjDnOB2MT-LpQxL-59JGKJQhjNWh6WERAly6u5y6TyjNLttT8Of5TXBR78HROSjJOcq46fq4tehHRwtUoeWDTm5-nTtbQMDR8wLnQjLTj3-p7W3xJ7Je6IhIos2l85OCFRjTLhj5ObepoXa4RXHC7QBROoHJcfKROvhjRlWl8yyxom3bvxtKcJWJ8X0-j_Df71Lno1MUtnj4QIXTjQ2mAeaDFhtI0hhC-Ce5Rb5nbHhfuX5-RLfbueoPOF5lOTJh0R5brWy6FdBpOvyb-J0bc05l5cB4nIDIj_ejbke6JWDH_JJTksbCo0WbuEKbREHnkkM48_-P4Den79BRJZ5m7mXp0bbIt-HITJ5fjNDxDLjbuj3Mkq0G6voJRV0KOkbC86Dj_MD5vM-Ub2eRkX2DPX3b7EfhkBs-O_bfbT2MbybxjP5jcmbmDeBU3p24bFMno8eDcvyUPnbGbZqjtftRIJoIPQbRrEDnuz-PvE-PnHMx8X5-RLf2THM-OF5lOTJh0R550--TFd5tcZ-UTJWjvW5hPK0xjihRRYLTbke4tX-NFHJT8qJf5; delPer=0; BD_CK_SAM=1; PSINO=3; H_PS_645EC=3f5aHhDvj1bK2tad0LSaTg60nY5rTPXsO3SeJFBZSIrrg19kguik5iN%2Fz2I; ZD_ENTRY=baidu; BD_HOME=1; sugstore=1");
            connection.connect();

            if (connection.getResponseCode()==200){
                 stream= connection.getInputStream();
                 bf=new BufferedReader(new InputStreamReader(stream,"UTF-8"));
                StringBuffer sb =new StringBuffer();
                String temp=null;
                while ((temp=bf.readLine())!=null){
                    sb.append(temp+"\r\n");
                    Log.v("tddys",sb.toString());
                }
                resp=sb.toString();
            }

        }catch (MalformedURLException e){

        }catch (IOException e){

        }finally {
            if(null !=bf){
                try {
                    bf.close();

                } catch (IOException E){
                    E.printStackTrace();
                }
            }

            if (null !=stream){
                try {
                    stream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
         connection.disconnect();

        }
return resp;

    }
}
