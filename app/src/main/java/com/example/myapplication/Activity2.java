package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private Button add;
    private Button mul;
    private Button sub;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        add = (Button)findViewById(R.id.add);
        mul = (Button)findViewById(R.id.mul);
        sub = (Button)findViewById(R.id.sub);
        result = (TextView)findViewById(R.id.result);

        //Intent intent = getIntent();
        //int num1 = intent.getIntExtra("n1", 0); //default value is necessary for code to work
        //int num2 = intent.getIntExtra("n2", 0);
        Bundle extras = getIntent().getExtras();
        int num1 = extras.getInt("n1", 0);
        int num2 = extras.getInt("n2", 0);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 + num2;
                result.setText("La Reponse:" + String.valueOf(sum));
                Toast.makeText(Activity2.this, "sum", Toast.LENGTH_SHORT).show();
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 * num2;
                result.setText("La Reponse:" + String.valueOf(sum));
                Toast.makeText(Activity2.this, "mul", Toast.LENGTH_SHORT).show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 - num2;
                result.setText("La Reponse:" + String.valueOf(sum));
                Toast.makeText(Activity2.this, "sub", Toast.LENGTH_SHORT).show();
            }
        });
    }

}