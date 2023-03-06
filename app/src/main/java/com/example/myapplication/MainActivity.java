package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText n1;
    private EditText n2;
    private Button btn;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText)findViewById(R.id.num1);
        n2 = (EditText)findViewById(R.id.num2);

        btn = (Button)findViewById(R.id.goNext);
        result = (TextView)findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("n1", Integer.parseInt(n1.getText().toString()));
                intent.putExtra("n2", Integer.parseInt(n2.getText().toString()));
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        String str = "La reponse: ";

        int sum = intent.getIntExtra("sum", 0);
        if (resultCode == 1){
            Log.v("sum", String.valueOf((sum)));
            str += String.valueOf(sum);
        }
        if (resultCode == 2){
            Log.v("sum", String.valueOf((sum)));
            str += String.valueOf(sum);
        }
        if (resultCode == 2){
            Log.v("sum", String.valueOf((sum)));
            str += String.valueOf(sum);
        }
        Toast.makeText(this, sum, Toast.LENGTH_SHORT).show();
        result.setText(str);
    }
}