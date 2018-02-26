package com.example.atahanylmz.howlong;

import java.util.Calendar;

public class ClockItem {
    private String name;
    private int id;
    private static int counter = 0;
    private int endDay;
    private int endMonth;
    private int endYear;
    private long currentTime;
    private int currentDay;
    private int curentMonth;
    private int currentYear;


    public ClockItem(int endDay, int endMonth, int endYear) {
        this.id = counter;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        counter++;
        currentTime = Calendar.getInstance().getTimeInMillis();
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getCurrentTime() {
        return currentTime;
    }


}
