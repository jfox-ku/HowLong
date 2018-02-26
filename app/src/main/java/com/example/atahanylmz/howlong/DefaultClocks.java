package com.example.atahanylmz.howlong;

import java.util.ArrayList;

/**
 * Created by atahanylmz on 26.02.2018.
 */

class DefaultClocks {
    private static final DefaultClocks ourInstance = new DefaultClocks();
    public static ArrayList<ClockItem> clockList;

    static DefaultClocks getInstance() {
        return ourInstance;
    }

    private DefaultClocks() {
        clockList = new ArrayList<ClockItem>();
        clockList.add(new ClockItem(1, 1, 2019));

    }


}
