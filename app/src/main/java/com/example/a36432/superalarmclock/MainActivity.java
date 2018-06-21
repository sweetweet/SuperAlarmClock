package com.example.a36432.superalarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import static android.graphics.Color.parseColor;

public class MainActivity extends AppCompatActivity {
    private Button note;
    private Button set;
    private Button weather;
    AnalogClock clock;

    String DATABASETABLE = "clock";
    String DATABASE_CREATETABLE = "create table notetable (title, content);";
    ClockDB helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = (Button) findViewById(R.id.btn_memo);
        set = (Button) findViewById(R.id.btn_set);
        weather = (Button) findViewById(R.id.btn_weather);
        clock = (AnalogClock) findViewById(R.id.Clock);

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                // Create a new instance of TimePickerDialog and return it

                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minutes) {
                        /*SQLiteDatabase db = helper.getReadableDatabase();
                        ContentValues cv = new ContentValues();
                        cv.put("hour", hourOfDay);
                        cv.put("minute", minutes);
                        db.insert(DATABASETABLE, null, cv);*/
                        registerReceiver(new PlayReceiver() , new IntentFilter("clock"));

                        Calendar mCal = Calendar.getInstance();

                        mCal.setTimeInMillis(System.currentTimeMillis());
                        mCal.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        mCal.set(Calendar.MINUTE,minutes);
                        mCal.set(Calendar.SECOND,00);
                        Intent intentAlarm = new Intent("clock");

                        AlarmManager am = (AlarmManager) MainActivity.this.getSystemService(Context.ALARM_SERVICE);

                      PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);



                        am.setRepeating(AlarmManager.RTC_WAKEUP, mCal.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pi);
                        Toast.makeText(MainActivity.this, "設置鬧鐘的時間為："+String.valueOf(hourOfDay)+":"+String.valueOf(minutes), Toast.LENGTH_SHORT).show();

                    }
                }, hour, minute, true).show();


            }

        });

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, NoteActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SetActivity.class);
                startActivity(intent);

            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        final LinearLayout background = (LinearLayout)findViewById(R.id.back);
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        if (data==null){
            return;
        }
        Bundle bundle =this.getIntent().getExtras();

        int id = bundle.getInt("ID");
        switch(id){
            case R.id.btn_red:
                background.setBackgroundColor(parseColor("#e3170d"));
               break;
        }

    }



    class ClockDB extends SQLiteOpenHelper {
        public ClockDB(Context context) {
            super(context, "clock.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATETABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public class PlayReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent)
        {

            System.out.println("get receive");

            Intent intent2 = new Intent(MainActivity.this,WakeupActivity.class);
            startActivity(intent2);

        }
    }
}