package com.example.a36432.superalarmclock;

import android.content.ContentUris;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WakeupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakeup);
        int i ;
        MediaPlayer mediaPlayer;


        mediaPlayer = MediaPlayer.create(this, R.raw.wakeup);

            mediaPlayer.start();




    }
}
