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
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        add = (Button)findViewById(R.id.add);
        mul = (Button)findViewById(R.id.mul);
        sub = (Button)findViewById(R.id.sub);
        result = (TextView)findViewById(R.id.result);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("n1", 0); //default value is necessary for code to work
        int num2 = intent.getIntExtra("n2", 0);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 + num2;
                result.setText("La Reponse:" + String.valueOf(sum));
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 * num2;
                result.setText("La Reponse:" + String.valueOf(sum));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = num1 - num2;
                result.setText("La Reponse:" + String.valueOf(sum));
            }
        });
    }

    public void openActivityMain() {
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        startActivity(intent);
    }
}