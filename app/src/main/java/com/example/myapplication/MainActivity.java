package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView pr;
    //private Button btn;
    private EditText txt;
    private TextView rst;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pr = (TextView)findViewById(R.id.pr);
        //btn = (Button)findViewById(R.id.btn1);
        rst = (TextView)findViewById(R.id.result);
        txt = (EditText)findViewById(R.id.text1);
        bar = (ProgressBar)findViewById(R.id.bar);
        bar.setVisibility(View.GONE);
    }

    public void myThread(View v){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=40; i++){
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    final int valeur = i;
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pr.setText(valeur + "%");
                            bar.setVisibility(View.VISIBLE);
                            bar.setProgress(valeur);
                        }
                    });
                }
                bar.setVisibility(View.INVISIBLE);
                String text = txt.getText().toString();
                rst.setText(text);
            }
        });
        t.start();
    }
}