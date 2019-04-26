package xmltest;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tdd on 2019/3/26.
 */

public class BeautyServerJson {

    String urlOfStoreAndIntegral = "https://calm4.keruyun.com/CalmRouter/v2/cashHandOver/stats";
    String brandId = "57174";
    String shopId ="810173379";
    String token="kry_token_db77d7ab-b135-4fb2-9623-9f19a1b66005";

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static String encrypt(String strSrc,String encName) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if(encName == null || encName.isEmpty()){
                encName = "SHA-256";
            }
            md = MessageDigest.getInstance(encName);//加密算法可使用MD5,SHA-1,SHA-256,SHA-512
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    public Map<String, String> tokenEncrypt() {
        Map<String, String> tempMap = new HashMap<>();
            Long shopIdEncrypt = Long.parseLong(shopId) ^ 512;
            String curTime = System.currentTimeMillis() + "";
            String encryptData = "kry-api-token=" + token + "&kry-api-shop-id=" + shopIdEncrypt + "&kry-api-timestamp=" + curTime;
            String securityEncrypt = encrypt(encryptData, "SHA-256");
            tempMap.put("token", securityEncrypt);
            tempMap.put("time", curTime);

        return tempMap;
    }

    public void DeleteUnpayBeautyOrder() {

        TreeMap bodyMap = new TreeMap();
        bodyMap.put("shopID", shopId);
        bodyMap.put("brandID", brandId);
        bodyMap.put("deviceID", "dc:20:08:4a:fd:74");
        bodyMap.put("versionCode", "CalmAutoTest");
        bodyMap.put("versionName", "CalmAutoTest");
        bodyMap.put("appType", "5");
        bodyMap.put("systemType", "CalmAutoTest");
        bodyMap.put("opVersionUUID", "60806b27f8d84548995b13c02aacaf20");
        bodyMap.put("timeZone", "Asia/Shanghai");


        TreeMap returnInventoryItemsMap = new TreeMap();
        returnInventoryItemsMap.put("bussinessType",2);
        returnInventoryItemsMap.put("checkClearAccount",true);
        returnInventoryItemsMap.put("checkUnpaid",false);


        bodyMap.put("content", returnInventoryItemsMap);
        Gson gson1 = new Gson();
        String bodyFromRepay = gson1.toJson(bodyMap);

        StringBuffer sb = null;
        try {
            URL url = new URL(urlOfStoreAndIntegral);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Map<String, String> apiSignMap = tokenEncrypt();
            connection.setRequestProperty("kry-api-sign", apiSignMap.get("token"));
            connection.setRequestProperty("kry-api-timestamp", apiSignMap.get("time"));
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.setRequestProperty("kry-api-brand-id", brandId);
            connection.setRequestProperty("kry-api-device-id", "dc:20:08:4a:fd:74");
            connection.setRequestProperty("kry-api-shop-id", shopId);

            connection.connect();

            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(bodyFromRepay);
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            reader.close();
            // 断开连接
            connection.disconnect();
            System.out.println(sb.toString());

        } catch (IOException e) {
            Assert.fail("调作废订单接口出错: ");

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BeautyServerJson().DeleteUnpayBeautyOrder();
    }


}
