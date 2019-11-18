package com.example.a210.myapplication;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity{
    ImageView imageview;
    TextView username;
    TextView phone;
    TextView location;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        imageview = (ImageView)findViewById(R.id.img1);
        username = (TextView)findViewById(R.id.username);
        phone = (TextView)findViewById(R.id.phone);
        location = (TextView)findViewById(R.id.location);

        Intent it = getIntent();

        int imageNumber = it.getIntExtra("image",0)
    }
}
