package com.example.android.quakereport;

public class Earthquake {

    private String magnitude;
    private String place;
    private long timeInMillis;

    public Earthquake(String magnitude, String place, long time) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMillis = time;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }
}
