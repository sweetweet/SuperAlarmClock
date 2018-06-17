package com.example.a36432.superalarmclock;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SetBackActivity extends AppCompatActivity {

    private Button red;
    private Button yellow;
    private Button blue;
    private Button orange;
    private Button note;
    private Button weather;
    private Button home;
    private Button explore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_back);

        red=(Button)findViewById(R.id.btn_red);
        yellow=(Button)findViewById(R.id.btn_yellow);
        blue=(Button)findViewById(R.id.btn_blue);
        orange=(Button)findViewById(R.id.btn_orange);
        home=(Button)findViewById(R.id.btn_home);
        note=(Button)findViewById(R.id.btn_memo);
        weather=(Button)findViewById(R.id.btn_weather);
        explore=(Button)findViewById(R.id.btn_exp);

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, WeatherActivity.class);
                startActivity(intent);
                //finish();

            }
        });

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, NoteActivity.class);
                startActivity(intent);
                //finish();

            }
        });

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetBackActivity.this, ExploreActivity.class);
                startActivity(intent);

            }
        });

    }
}

