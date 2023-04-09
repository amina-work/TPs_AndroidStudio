package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pb;
    private TextView pr;
    private Button btn1;
    private Button btn2;
    private EditText txt;
    private TextView rst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.bar);
        pr = (TextView)findViewById(R.id.pr);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        rst = (TextView)findViewById(R.id.result);
        txt = (EditText)findViewById(R.id.text1);

        final ExampleAsync[] task = {new ExampleAsync(pb, btn1, btn2)};
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (task[0] == null || task[0].getStatus() == AsyncTask.Status.FINISHED) {
                    // Create a new instance of ExampleAsync if it doesn't exist or if it has finished
                    task[0] = new ExampleAsync(pb, btn1, btn2);
                    task[0].execute();
                } else if (task[0].getStatus() == AsyncTask.Status.RUNNING) {
                    // If the task is already running, do nothing
                } else {
                    // If the task is not finished and not running, it must be cancelled, so create a new instance and start it
                    task[0] = new ExampleAsync(pb, btn1, btn2);
                    task[0].execute();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task[0].cancel(true);
                task[0].stop();
            }
        });
    }
    private class ExampleAsync extends AsyncTask<Void, Integer, Void> {
        private ProgressBar pb;
        private Button btn1, btn2;
        private Boolean running; //To manipulate UI from the AsyncThread
        private int valeur;
        public ExampleAsync(ProgressBar pb, Button btn1, Button btn2){
            this.pb = pb;
            this.btn1 = btn1;
            this.btn2 = btn2;
            this.running = true;
        }
        @Override
        protected void onPreExecute() {
            valeur = 0;
            //super.onPreExecute();
            pb.setProgress(valeur);
            btn1.setEnabled(false);
            btn2.setEnabled(true);
        }
        public void  stop(){
            running = false;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            while (valeur < 100){
                if(isCancelled()){
                    break;
                }
                valeur++;
                publishProgress(valeur);
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            //super.onProgressUpdate(values);
            pr.setText(values[0] + "%");
            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String text = txt.getText().toString();
            rst.setText(text);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
        }
        protected void onCancelled() {
            super.onCancelled();
            pb.setProgress(valeur);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
        }
    }

}