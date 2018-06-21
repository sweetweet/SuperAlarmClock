package com.example.a36432.superalarmclock;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    private Button note;
    private Button set;
    private Button home;


    private static final int LIST_HOTELS = 1;


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case LIST_HOTELS: {

                    break;
                }
            }
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        note=(Button)findViewById(R.id.btn_memo);
        set=(Button)findViewById(R.id.btn_set);
        home=(Button)findViewById(R.id.btn_home);




        getHotelFromFireBase();



        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WeatherActivity.this, NoteActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WeatherActivity.this, SetActivity.class);
                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(WeatherActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }



    private void getHotelFromFireBase(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new FirebaseThread(dataSnapshot).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("Hotel", databaseError.getMessage());
            }
        });
    }


    class FirebaseThread extends Thread {
        private DataSnapshot dataSnapshot;
        public FirebaseThread(DataSnapshot dataSnapshot) {
            this.dataSnapshot = dataSnapshot;
        }
        public void run() {
            handler.post(rb);
        }
        Runnable rb = new Runnable() {

            @Override
            public void run() {
                String Name;
                String Temperature;
                String Weather;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    DataSnapshot dsName = ds.child("SiteName");
                    DataSnapshot dsTemperature = ds.child("Temperature");
                    DataSnapshot dsWeather = ds.child("Weather");
                    Name = (String) dsName.getValue();
                    Temperature = (String) dsTemperature.getValue();
                    Weather = (String) dsWeather.getValue();
                    Log.d("cityname", Name);
                    TextView tv_city = (TextView) findViewById(R.id.City);
                    TextView tv_weather = (TextView) findViewById(R.id.Weather);
                    TextView tv_temperature = (TextView) findViewById(R.id.Temperature);
                    tv_city.postInvalidate();
                    tv_city.setText(Name);
                tv_weather.postInvalidate();
                tv_weather.setText(Weather);
                tv_temperature.postInvalidate();
                tv_temperature.setText("氣溫:"+Temperature+"℃ ");

                    if (Name.equals("臺中")) break;

                }


            }
        };


    }
}
