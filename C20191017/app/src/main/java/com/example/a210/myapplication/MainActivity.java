package com.example.a210.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1, t2;
    Button add, sub, mul, div;
    TextView Result;
    String t1_s,t2_s;
    Integer last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (EditText) findViewById(R.id.t1);
        t2 = (EditText) findViewById(R.id.t2);

        add = (Button) findViewById(R.id.sum);
        sub = (Button) findViewById(R.id.ppap);
        mul = (Button) findViewById(R.id.gop);
        div = (Button) findViewById(R.id.div);

        Result = (TextView) findViewById(R.id.result);

        add.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                t1_s = t1.getText().toString();
                t2_s = t2.getText().toString();
                last = Integer.parseInt(t1_s) + Integer.parseInt(t2_s);
                Result.setText("계산결과 : " + last.toString());
                return false;
            }
        });

        sub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                t1_s = t1.getText().toString();
                t2_s = t2.getText().toString();
                last = Integer.parseInt(t1_s) - Integer.parseInt(t2_s);
                Result.setText("계산결과 : " + last.toString());
                return false;
            }
        });

        mul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                t1_s = t1.getText().toString();
                t2_s = t2.getText().toString();
                last = Integer.parseInt(t1_s) * Integer.parseInt(t2_s);
                Result.setText("계산결과 : " + last.toString());
                return false;
            }
        });

        div.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                t1_s = t1.getText().toString();
                t2_s = t2.getText().toString();
                last = Integer.parseInt(t1_s) / Integer.parseInt(t2_s);
                Result.setText("계산결과 : " + last.toString());
                return false;
            }
        });
    }
}
