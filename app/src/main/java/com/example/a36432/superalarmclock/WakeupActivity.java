package com.example.a36432.superalarmclock;

import android.content.ContentUris;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WakeupActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakeup);

        mediaPlayer = MediaPlayer.create(this, R.raw.wakeup);

            mediaPlayer.start();


    }

    public void stop(View view){
        mediaPlayer.stop();
        finish();
    }


}
