package com.shishike.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


/**
 * Created by tdd on 2019/1/17.
 */

public class FirstActivity extends Activity {
    private static final int MSG_SUCCESS = 0;
    private static final int MSG_FAILURE = 1;
    String a;
    int b=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        final Handler mainHandler=new Handler(){

            public void handleMessage (Message msg) {
                switch(msg.what) {
                    case MSG_SUCCESS:

                        Toast.makeText(FirstActivity.this, a, Toast.LENGTH_SHORT).show();
                        //TextView textView =(TextView)findViewById(R.id.显示);
                        //textView.setText(a);
                        break;

                    case MSG_FAILURE:
                        Toast.makeText(FirstActivity.this, "投票官方限制，投票失败", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        Button button = (Button) findViewById(R.id.登录);

        Button button2 = (Button) findViewById(R.id.跳转);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        StringRequest str = new StringRequest(Request.Method.GET, "https://www.tmjl.ai/api/marketing/sichuan_voice_vote/vote?optionCodes=35",
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        // TODO: 处理返回结果
                                        mainHandler.obtainMessage(MSG_SUCCESS).sendToTarget();
                                        if(response.contains("t")){
                                            b++;
                                            a="给薇薇投票成功"+b+"次";
                                        }else{
                                            a="给薇薇投票失败";
                                        }

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // TODO: 处理错误
                                        Log.i("### onErrorResponse", "GET_StringRequest:" + error.toString());
                                        mainHandler.obtainMessage(MSG_FAILURE).sendToTarget();
                                    }
                                });
                        while (true){
                            Myapplication.getRequestQueue().add(str);
                            long b=5000;
                            try {
                                Thread.sleep(b);
                            }catch (InterruptedException E){
                            }

                        }

                    }


                }).start();

                }
        });
    }

    //public void tdd(View view){Toast.makeText(FirstActivity.this,"you have clicked Button", Toast.LENGTH_SHORT).show();}

    public void tdds(View view){
        final AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(FirstActivity.this);
        alterDiaglog.setIcon(R.drawable.chat);//图标
        alterDiaglog.setTitle("简单的dialog");//文字
        alterDiaglog.setMessage("生存还是死亡");//提示消息
        //积极的选择
        alterDiaglog.setPositiveButton("生存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FirstActivity.this,"点击了生存",Toast.LENGTH_SHORT).show();
            }
        });
        //消极的选择
        alterDiaglog.setNegativeButton("死亡", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FirstActivity.this,"点击了死亡",Toast.LENGTH_SHORT).show();
            }
        });
        //中立的选择
        alterDiaglog.setNeutralButton("不生不死", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FirstActivity.this,"点击了不生不死",Toast.LENGTH_SHORT).show();
            }
        });

        //显示
        alterDiaglog.show();

    }
}


