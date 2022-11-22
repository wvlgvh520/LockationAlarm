package com.example.lockalarm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView menu, add;

    private ArrayList<Alarm> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rcv_alarmList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<>();

        //arrayList.add(new Alarm("[더미]기숙사", "11월 26일 (토)", "12", "35", true));

        AlarmAdapter adapter = new AlarmAdapter(arrayList);
        recyclerView.setAdapter(adapter);


        add = findViewById(R.id.btn_addAlarm);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });
    }

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
}