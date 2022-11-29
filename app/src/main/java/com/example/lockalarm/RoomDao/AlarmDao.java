package com.example.lockalarm.RoomDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AlarmDao {

    @Query("Select * From alarm")
    List<Alarm> getAllalarm();

    @Insert
    void insertAlarm(Alarm alarm);

    @Delete
    void alarmDelete(Alarm alarm);

    @Update
    void alarmUpdate(Alarm alarm);



}
