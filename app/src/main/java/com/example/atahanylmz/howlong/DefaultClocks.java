package com.example.atahanylmz.howlong;

import java.util.ArrayList;

class DefaultClocks {

    private static final DefaultClocks ourInstance = new DefaultClocks();
    public static ArrayList<ClockItem> clockList;

    static DefaultClocks getInstance() {
        return ourInstance;
    }

    //TODO Put the data in a firebase project and fetch it from the Realtime Database
    private DefaultClocks() {
        clockList = new ArrayList<ClockItem>();
        clockList.add(new ClockItem("First Date", 26, 2, 2019));
        clockList.add(new ClockItem("Second Date", 4, 4, 2020));
        clockList.add(new ClockItem("Third Date", 8, 8, 2021));
        clockList.add(new ClockItem("Fancy Date", 16, 12, 2022));

    }


}
