package com.example.a36432.superalarmclock;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class SetMusicApplyActivity extends AppCompatActivity{
    private Button note;
    private Button set;
    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_music_apply);

        note=(Button)findViewById(R.id.btn_memo);
        set=(Button)findViewById(R.id.btn_set);
        home=(Button)findViewById(R.id.btn_home);

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicApplyActivity.this, NoteActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicApplyActivity.this, SetActivity.class);
                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicApplyActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }



}
