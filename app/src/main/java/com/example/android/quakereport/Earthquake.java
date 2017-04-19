package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String place;
    private long timeInMillis;
    private String url;

    public Earthquake(double magnitude, String place, long time, String url) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMillis = time;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public String getUrl() {
        return url;
    }
}
