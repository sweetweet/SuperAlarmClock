package com.example.a36432.superalarmclock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetMusicActivity extends AppCompatActivity {
    private Button fav;
    private Button res;
    private Button apl;
    private Button bui;

    private Button mobile;
    private Button built;
    private Button fri;

    private Button note;
    private Button weather;
    private Button home;
    private Button explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_music);

        fav=(Button)findViewById(R.id.btn_favor);
        apl=(Button)findViewById(R.id.btn_phone);
        res=(Button)findViewById(R.id.btn_initial);
        bui=(Button)findViewById(R.id.btn_in);

        home=(Button)findViewById(R.id.btn_home);
        note=(Button)findViewById(R.id.btn_memo);
        weather=(Button)findViewById(R.id.btn_weather);
        explore=(Button)findViewById(R.id.btn_exp);

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, SetMusicFavoritesActivity.class);
                startActivity(intent);
            }
        });

        apl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, SetMusicApplyActivity.class);
                startActivity(intent);
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, SetMusicResetActivity.class);
                startActivity(intent);
            }
        });

        bui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, SetMusicBulitinActivity.class);
                startActivity(intent);
            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, WeatherActivity.class);
                startActivity(intent);
                //finish();

            }
        });

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, NoteActivity.class);
                startActivity(intent);
                //finish();

            }
        });

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicActivity.this, ExploreActivity.class);
                startActivity(intent);

            }
        });
    }
}
