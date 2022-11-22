package com.example.lockalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class SettingActivity extends AppCompatActivity {

    TimePicker timePicker;
    TextView tv_location, tv_time, tv_date;
    Button btn_cancel, btn_save;
    String tv_hour="00", tv_minute="00";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Context context = getApplicationContext();
        Intent intent = getIntent();


        timePicker = findViewById(R.id.timepicker);
        tv_time = findViewById(R.id.tv_time);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_save = findViewById(R.id.btn_save);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                tv_time.setText(hour + ":" + minute);
                tv_hour = Integer.toString(hour);
                tv_minute = Integer.toString(minute);
            }
        });

        //취소 버튼 클릭시 액티비티 종료
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //저장 버튼 클릭 시 액티비티 종료 및 인텐트
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //조건문으로 날짜선택해야 저장되도록 할것!
                String time = tv_time.getText().toString();
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                intent.putExtra("location", "dummy");
                intent.putExtra("timeH", tv_hour);
                intent.putExtra("timeM", tv_minute);
                intent.putExtra("date", "00월 00일 (목)");
                startActivity(intent);
                finish();
            }
        });

        tv_date = findViewById(R.id.tv_dayOfWeek);

    }
}