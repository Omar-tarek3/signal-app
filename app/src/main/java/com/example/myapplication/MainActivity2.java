package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity  {
    Button map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent rec = getIntent();
        map=(Button) findViewById(R.id.map);
        onClick();

    }

    void onClick()
    {
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendtomap = new Intent(MainActivity2.this, MapsActivity.class);
                startActivity(sendtomap);



            }
        });
    }
}