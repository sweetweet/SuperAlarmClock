package com.example.a36432.superalarmclock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoteItemActivity extends AppCompatActivity {

    private Button home;
    private Button set;
    private Button weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_item);

        home=(Button)findViewById(R.id.btn_home);
        set=(Button)findViewById(R.id.btn_set);
        weather=(Button)findViewById(R.id.btn_weather);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(NoteItemActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(NoteItemActivity.this, SetActivity.class);
                startActivity(intent);

            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(NoteItemActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });
    }
}
