package com.example.atahanylmz.howlong;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void updateFragment(Fragment fr, int layoutID) {
        getSupportFragmentManager().beginTransaction().replace(layoutID, fr).commit();
    }


}
