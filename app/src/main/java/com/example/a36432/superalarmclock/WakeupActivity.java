package com.example.a36432.superalarmclock;

import android.content.ContentUris;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WakeupActivity extends AppCompatActivity {
    private NoteDB DB;
    private SQLiteDatabase dbread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wakeup);

        String msg = "";
        Button stop_btn = (Button)findViewById(R.id.btn_stop);
        TextView tv_msg = (TextView)findViewById(R.id.tv_note);

        DB = new NoteDB(this);
        dbread = DB.getReadableDatabase();
        Cursor c = dbread.rawQuery("select * from note",null);
        c.moveToFirst();
        Log.d("sql",c.getString(1));
        for(int i=0;i<c.getCount();i++){
            msg = msg + c.getString(1)+"  ";
            c.moveToNext();
        }
        tv_msg.setText(msg);

        final MediaPlayer mediaPlayer;


        mediaPlayer = MediaPlayer.create(this, R.raw.wakeup);

        mediaPlayer.start();


        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                finish();
            }
        });

    }
}
