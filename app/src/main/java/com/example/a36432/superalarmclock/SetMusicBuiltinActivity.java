package com.example.a36432.superalarmclock;

import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.File;

public class SetMusicBuiltinActivity extends AppCompatActivity{
    private Button note;
    private Button set;
    private Button home;

    private Button mButtonAlarm;

    public static final int CODE_ALARM = 1;


    private String strAlarmFolder = "/system/media/audio/alarms";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_music_builtin);


        note=(Button)findViewById(R.id.btn_memo);
        set=(Button)findViewById(R.id.btn_set);
        home=(Button)findViewById(R.id.btn_home);

        mButtonAlarm=(Button)findViewById(R.id.btn_alarm);



        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicBuiltinActivity.this, NoteActivity.class);
                startActivity(intent);

            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicBuiltinActivity.this, SetActivity.class);
                startActivity(intent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SetMusicBuiltinActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        mButtonAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasFolder(strAlarmFolder)) {
                    // 打开系统铃声设置
                    Intent intent = new Intent(
                            RingtoneManager.ACTION_RINGTONE_PICKER);
                    // 设置铃声类型和title
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE,
                            RingtoneManager.TYPE_ALARM);
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE,
                            "設置鬧鐘鈴聲");
                    // 当设置完成之后返回到当前的Activity
                    startActivityForResult(intent, CODE_ALARM);
                    finish();
                }
            }
        });


    }

    /**
     * 当设置铃声之后的回调函数
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        // 得到我们选择的铃声
        Uri pickedUri = data
                .getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
        if (pickedUri != null) {
            switch (requestCode) {

                case CODE_ALARM:
                    // 将我们选择的铃声设置成为默认闹钟铃声
                    RingtoneManager.setActualDefaultRingtoneUri(this,
                            RingtoneManager.TYPE_ALARM, pickedUri);

                    grantUriPermission("com.android.systemui", pickedUri,
                            Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    break;

            }
        }
    }

    /**
     * 检测是否存在指定的文件夹,如果不存在则创建
     *
     * @param strFolder
     *            文件夹路径
     */
    private boolean hasFolder(String strFolder) {
        boolean btmp = false;
        File f = new File(strFolder);
        if (!f.exists()) {
            if (f.mkdirs()) {
                btmp = true;
            } else {
                btmp = false;
            }
        } else {
            btmp = true;
        }
        return btmp;
    }



}

