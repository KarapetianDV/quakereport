package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String place;
    private long timeInMillis;

    public Earthquake(double magnitude, String place, long time) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMillis = time;
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
}
