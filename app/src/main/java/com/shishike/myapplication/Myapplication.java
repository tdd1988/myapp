package com.shishike.myapplication;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tdd on 2019/4/4.
 */

public class Myapplication extends Application {



    //Volley的全局请求队列
    public static RequestQueue sRequestQueue;

    /**
     * @return Volley全局请求队列
     */
    public static RequestQueue getRequestQueue() {
        return sRequestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //实例化Volley全局请求队列
        sRequestQueue = Volley.newRequestQueue(getApplicationContext());
    }
}

