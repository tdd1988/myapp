package com.shishike.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.nio.ByteBuffer;

/**
 * Created by tdd on 2019/4/9.
 */

public class SecondActivity extends Activity {

    private Handler handler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        final ImageView imageView=(ImageView)findViewById(R.id.imageView2);
        final ProgressDialog dialog = new ProgressDialog(this);

        dialog.setTitle("提示信息");
        dialog.setMessage("正在下载222，请稍后...");
        dialog.setCancelable(false);
        Button button=(Button)findViewById(R.id.下载);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Mythread()).start();
                dialog.show();
            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    byte[] data = (byte[]) msg.obj;
                    Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                    imageView.setImageBitmap(bmp);

                    dialog.dismiss();

                }
            }
        };

    }


    class Mythread extends Thread{
        @Override
        public void run() {
            super.run();
            ImageRequest img= new ImageRequest("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554804365211&di=03d48e6f107ae618d18083ac77f16da7&imgtype=0&src=http%3A%2F%2Fattachments.gfan.net.cn%2Fforum%2F201703%2F01%2F170855vnnngp4vhn3icn7i.jpg",
                    new Response.Listener<Bitmap>(){
                        @Override
                        public void onResponse(Bitmap response) {
                            int bytes = response.getByteCount();
                            ByteBuffer buffer = ByteBuffer.allocate(bytes);
                            response.copyPixelsToBuffer(buffer);
                            byte[] bd=buffer.array();
                            Message message =Message.obtain();
                            message.obj=bd;
                            message.what=1;
                            handler.sendMessage(message);
                        }
            },0, 0, Bitmap.Config.RGB_565,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
            Myapplication.getRequestQueue().add(img);
        }
    }
}
