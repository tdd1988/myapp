package com.shishike.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tdd on 2019/5/23.
 */

public class Fouthactivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fouthxml);
        ImageView im=(ImageView)findViewById(R.id.imageView);

        //im.scrollTo(500,0);
        //TextView tes=(TextView)findViewById(R.id.zuobiaos);
        //tes.setText("houlaiu"+im.getScrollX());

    }
}
