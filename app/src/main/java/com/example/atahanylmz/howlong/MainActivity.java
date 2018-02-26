package com.example.atahanylmz.howlong;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MainActivity extends BaseActivity implements ClockFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = ClockFragment.newInstance(1);
        updateFragment(fragment, R.id.fragment_holder);

    }


    @Override
    public void onListFragmentInteraction(ClockItem item) {
        System.out.println("Something was clicked!");
    }
}
