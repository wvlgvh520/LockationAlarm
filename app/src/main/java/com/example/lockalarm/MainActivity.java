package com.example.lockalarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.lockalarm.RoomDao.AlarmData;
import com.example.lockalarm.RoomDao.AppDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView btn_add;
    RecyclerView recyclerView;
    public static final String TAG = "MAIN";
    List<AlarmData> arrayList = new ArrayList<>();
    AppDatabase database;
    AlarmAdapter alarmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcv_alarmList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = AppDatabase.getDBInstance(this);
        arrayList = database.alarmDao().getAllalarm();

        alarmAdapter = new AlarmAdapter(MainActivity.this, arrayList);
        recyclerView.setAdapter(alarmAdapter);

        //알람 추가 버튼 클릭함수
        btn_add = findViewById(R.id.btn_addAlarm);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);



                view = LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.edit_box, null, false);
                builder.setView(view);

                final Button btn_submit = view.findViewById(R.id.btn_submit);
                final EditText edit_location = view.findViewById(R.id.edit_location2);
                final TextView tv_time = view.findViewById(R.id.tv_time2);
                final TextView tv_date=  view.findViewById(R.id.tv_date2);

                final TimePicker timePicker = view.findViewById(R.id.timepicker2);
                final DatePicker datePicker = view.findViewById(R.id.datepicker2);
                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                        tv_time.setText(i + ":" + i1);
                    }
                });
                datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        tv_date.setText( (i1+1) + "월" +  i2 +"일");
                    }
                });

                final AlertDialog dialog = builder.create();

                btn_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String strLocation = edit_location.getText().toString();
                        String strTime = tv_time.getText().toString();
                        String strDate = tv_date.getText().toString();

                        AlarmData alarmData = new AlarmData(strTime, strDate, strLocation);
                        database.alarmDao().insertAlarm(alarmData);
                        dialog.dismiss();
                        arrayList.clear();
                        arrayList.addAll(database.alarmDao().getAllalarm());
                        alarmAdapter.notifyDataSetChanged();
                    }
                });
                dialog.show();
            }
        });
    }


}