package com.example.lockalarm.RoomDao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AlarmData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public static AppDatabase getDBInstance(Context context) {

        //Instance가 null이면 초기화
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                     AppDatabase.class, "DB_NAME").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract AlarmDao alarmDao();
}
