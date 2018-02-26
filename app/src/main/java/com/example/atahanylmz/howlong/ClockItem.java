package com.example.atahanylmz.howlong;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockItem {
    private String name;
    private int id;
    private static int counter = 0;
    private long currentTime;
    private long endTime;
    private int currentDay;
    private int currentMonth;
    private int currentYear;
    private int endDay;
    private int endMonth;
    private int endYear;


    public ClockItem(String name, int endDay, int endMonth, int endYear) {
        Calendar calEnd = new GregorianCalendar();
        Calendar calCurrent = new GregorianCalendar();
        calEnd.set(endYear, endMonth, endDay);
        currentTime = Calendar.getInstance().getTimeInMillis();
        endTime = calEnd.getTimeInMillis();
        calCurrent.setTimeInMillis(currentTime);
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.currentDay = calCurrent.get(Calendar.DAY_OF_MONTH);
        this.currentMonth = calCurrent.get(Calendar.MONTH) + 1;
        this.currentYear = calCurrent.get(Calendar.YEAR);

        this.id = counter;

        this.name = name;
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

    public String getFormattedCurrentDate() {
        return currentDay + "." + currentMonth + "." + currentYear;
    }

    public String getFormattedEndDate() {
        return endDay + "." + endMonth + "." + endYear;
    }

    public long getIntervalInDays() {
        long sub = endTime - currentTime;
        sub = sub / 86400000;
        sub = sub - 28;


        return sub;
    }

    public int getPercentComp() {
        System.out.println((((double) currentTime / endTime) * 100));
        return (int) (((double) currentTime / endTime) * 100);


    }


}
