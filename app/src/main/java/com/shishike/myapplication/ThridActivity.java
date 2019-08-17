package com.shishike.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;

/**
 * Created by tdd on 2019/5/8.
 */

public class ThridActivity extends Activity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thridxml);
        //progressBar =(ProgressBar)findViewById(R.id.progressbar);
        //new MyasyncTask().execute();
        Button button =(Button)findViewById(R.id.tiaozhuan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThridActivity.this, Fouthactivity.class);
                startActivity(intent);
            }
        });
    }

    class MyasyncTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0;i<=100;i++){
                publishProgress(i);
                try {
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            return null;
        }
    }
}
