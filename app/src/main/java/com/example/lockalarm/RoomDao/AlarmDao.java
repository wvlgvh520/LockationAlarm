package com.example.lockalarm.RoomDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AlarmDao {

    @Query("Select * From AlarmData")
    List<AlarmData> getAllalarm();

    @Insert
    void insertAlarm(AlarmData alarmData);

    @Delete
    void alarmDelete(AlarmData alarmData);

    @Update
    void alarmUpdate(AlarmData alarmData);



}
