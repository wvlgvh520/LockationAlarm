package com.example.lockalarm;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView menu, add;

    static final int REQ_ALARM = 1;
    private ArrayList<Alarm> arrayList;
    TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rcv_alarmList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<>();
       // arrayList.add(new Alarm("[더미]기숙사", "11월 26일 (토)", "12", "35", true));

        AlarmAdapter adapter = new AlarmAdapter(arrayList);
        recyclerView.setAdapter(adapter);


        //알람 추가 버튼 클릭함수
        add = findViewById(R.id.btn_addAlarm);
        add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                //원래 세팅에서 만지려했는데 잘 안되갖고 다이얼로그 띄울것!
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

                        Alarm alarmList = new Alarm(strLocation,strDate,strTime, true);
                        arrayList.add(alarmList);

                        adapter.notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

/*
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        String timeH = intent.getStringExtra("timeH");
        String timeM = intent.getStringExtra("timeM");
        String date = intent.getStringExtra("date");

        arrayList.add(new Alarm(location, date, timeH, timeM, true));
        AlarmAdapter adapter = new AlarmAdapter(arrayList);

        adapter.notifyDataSetChanged();

    }
*/
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQ_ALARM) {
            if (resultCode == RESULT_OK) {
                return;
            }
            String sendLocation = intent.getExtras().getString("location");
            tv_location.setText(sendLocation);
            String sendTimeH = intent.getExtras().getString("timeH");
            tv_timeH.setText(sendTimeH);
            String sendTimeM = intent.getExtras().getString("timeM");
            tv_timeM.setText(sendTimeM);
            String sendDate = intent.getExtras().getString("date");
            tv_date.setText(sendDate);

            arrayList.add(new Alarm(sendLocation, sendDate, sendTimeH, sendTimeM, true));

            RecyclerView recyclerView = findViewById(R.id.rcv_alarmList);
            AlarmAdapter adapter = new AlarmAdapter(arrayList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
    }
    */
}