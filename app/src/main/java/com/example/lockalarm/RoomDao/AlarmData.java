package com.example.lockalarm.RoomDao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class AlarmData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int alarm_id;

    @ColumnInfo(name = "alarm_time")
    public String alarm_time;

    @ColumnInfo(name = "alarm_date")
    public String alarm_date;

    @ColumnInfo(name = "alarm_location")
    public String alarm_location;

    public AlarmData(String alarm_time, String alarm_date, String alarm_location) {
        this.alarm_time = alarm_time;
        this.alarm_date = alarm_date;
        this.alarm_location = alarm_location;
    }

    public int getAlarm_id() {
        return alarm_id;
    }

    public void setAlarm_id(int alarm_id) {
        this.alarm_id = alarm_id;
    }

    public String getAlarm_time() {
        return alarm_time;
    }

    public void setAlarm_time(String alarm_time) {
        this.alarm_time = alarm_time;
    }

    public String getAlarm_date() {
        return alarm_date;
    }

    public void setAlarm_date(String alarm_date) {
        this.alarm_date = alarm_date;
    }

    public String getAlarm_location() {
        return alarm_location;
    }

    public void setAlarm_location(String alarm_location) {
        this.alarm_location = alarm_location;
    }


}
