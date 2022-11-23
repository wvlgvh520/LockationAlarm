package com.example.lockalarm;

public class Alarm {
    private String tv_location, tv_date, tv_time;
    private boolean tv_power;

    public Alarm(String tv_location, String tv_date, String tv_time, boolean tv_power) {
        this.tv_location = tv_location;
        this.tv_date = tv_date;
        this.tv_time = tv_time;
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

    public String getTv_time() {    return tv_time;    }

    public void setTv_time(String tv_time) {    this.tv_time = tv_time;    }

    public boolean isTv_power() {
        return tv_power;
    }

    public void setTv_power(boolean tv_power) {
        this.tv_power = tv_power;
    }
}
