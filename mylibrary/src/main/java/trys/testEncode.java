package trys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by tdd on 2019/2/28.
 */

public class testEncode {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.baidu.com");
        HttpURLConnection hl =(HttpURLConnection)url.openConnection();
        hl.setRequestMethod("GET");
        hl.setDoOutput(true);

// 设置是否从httpUrlConnection读入，默认情况下是true;
        hl.setDoInput(true);

// Post 请求不能使用缓存
        hl.setUseCaches(false);
        hl.connect();
        //InputStream fl=new InputStream(hl.getInputStream());
      InputStream FL =  hl.getInputStream();
        FileOutputStream fo =new FileOutputStream(new File("/Users/tdd/Desktop/ys.txt"));
        byte[] by=new byte[2048];
        int i;
        while ((i=FL.read(by,0,by.length))!=-1){
            fo.write(by,0,by.length);


        }



    }
}
