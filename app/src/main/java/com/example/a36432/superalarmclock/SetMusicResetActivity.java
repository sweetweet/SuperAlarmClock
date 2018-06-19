package com.example.a36432.superalarmclock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetMusicResetActivity extends AppCompatActivity{
    private Button note;
    private Button set;
    private Button home;
    private Button explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_music_reset);

        note=(Button)findViewById(R.id.btn_memo);
        set=(Button)findViewById(R.id.btn_set);
        home=(Button)findViewById(R.id.btn_home);
        explore=(Button)findViewById(R.id.btn_exp);

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicResetActivity.this, NoteActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicResetActivity.this, SetActivity.class);
                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicResetActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicResetActivity.this, ExploreActivity.class);
                startActivity(intent);

            }
        });
    }
}