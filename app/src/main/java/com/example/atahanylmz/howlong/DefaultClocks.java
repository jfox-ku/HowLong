package com.example.atahanylmz.howlong;

import java.util.ArrayList;

class DefaultClocks {

    private static final DefaultClocks ourInstance = new DefaultClocks();

    public static ArrayList<ClockItem> clockList;

    static DefaultClocks getInstance() {
        return ourInstance;
    }

    private DefaultClocks() {
        clockList = new ArrayList<>();
        clockList.add(new ClockItem(1, 1, 2019));
        clockList.add(new ClockItem(1, 1, 2020));
        clockList.add(new ClockItem(1, 1, 2021));
        clockList.add(new ClockItem(1, 1, 2022));

    }


}
