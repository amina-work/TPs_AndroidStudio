package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button add;
    private Button mul;
    private Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        add = (Button)findViewById(R.id.add);
        mul = (Button)findViewById(R.id.mul);
        sub = (Button)findViewById(R.id.sub);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("n1", -1); //default value is necessary for code to work
        int num2 = intent.getIntExtra("n2", -1);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 + num2;
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putExtra("sum", sum);
                setResult(1, intent);
                finish();
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 * num2;
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putExtra("sum", sum);
                setResult(2, intent);
                finish();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 - num2;
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putExtra("sum", sum);
                setResult(3, intent);
                finish();
            }
        });
    }


}