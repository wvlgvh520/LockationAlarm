package com.example.lockalarm;

public class Alarm {
    private String tv_location, tv_date, tv_hour, tv_minute;
    private boolean tv_power;

    public Alarm(String tv_location, String tv_date, String tv_hour, String tv_minute, boolean tv_power) {
        this.tv_location = tv_location;
        this.tv_date = tv_date;
        this.tv_hour = tv_hour;
        this.tv_minute = tv_minute;
        this.tv_power = tv_power;
    }

    public String getTv_location() {
        return tv_location;
    }

    public void setTv_location(String tv_location) {
        this.tv_location = tv_location;
    }

    public String getTv_date() {
        return tv_date;
    }

    public void setTv_date(String tv_date) {
        this.tv_date = tv_date;
    }

    public String getTv_hour() {
        return tv_hour;
    }

    public void setTv_hour(String tv_hour) {
        this.tv_hour = tv_hour;
    }

    public String getTv_minute() {
        return tv_minute;
    }

    public void setTv_minute(String tv_minute) {
        this.tv_minute = tv_minute;
    }

    public boolean isTv_power() {
        return tv_power;
    }

    public void setTv_power(boolean tv_power) {
        this.tv_power = tv_power;
    }
}
