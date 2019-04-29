package com.shishike.anzhuo;

import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by tdd on 2019/4/3.
 */

public class TestVolley {
    protected Context context =new Application().getApplicationContext();
    RequestQueue requestQueue = Volley.newRequestQueue(context);

    public void volleyStringRequestDemo_GET() {

        //Volley request，参数：请求方式，请求的URL，请求成功的回调，请求失败的回调
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.baidu.com", new Response.Listener<String>() {
            /**
             * 请求成功的回调
             * @param response 请求返回的数据
             */
            @Override
            public void onResponse(String response) {
                // TODO: 处理返回结果
                Log.i("### onResponse", "GET_StringRequest:" + response);
            }
        }, new Response.ErrorListener() {
            /**
             * 请求失败的回调
             * @param error VolleyError
             */
            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: 处理错误
                Log.e("### onErrorResponse", "GET_StringRequest:" + error.toString());
            }
        });


        //将request加入全局队列
        requestQueue.add(stringRequest);
    }

    public static void main(String[] args) {
        new TestVolley().volleyStringRequestDemo_GET();
    }


}
