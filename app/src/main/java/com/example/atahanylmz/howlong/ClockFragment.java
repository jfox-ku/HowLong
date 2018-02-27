package com.example.atahanylmz.howlong;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClockFragment extends Fragment {

    //TODO First fetch data using AsyncTask. Learn how they work. Commit your work in a different branch.
    //TODO Then fetch the data using AsyncTaskLoader and learn how loaders work. Commit your work in master branch.
    //TODO Display your empty view when there is no data to populate the RecyclerView.

    private static final String COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;
    private OnClockListFragmentInteractionListener mListener;

    public ClockFragment() {
    }

    @SuppressWarnings("unused")
    public static ClockFragment newInstance(int columnCount) {
        ClockFragment fragment = new ClockFragment();
        Bundle args = new Bundle();
        args.putInt(COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clock_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyClockRecyclerViewAdapter(DefaultClocks.clockList, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnClockListFragmentInteractionListener)
            mListener = (OnClockListFragmentInteractionListener) context;
        else
            throw new RuntimeException(context.toString() + " must implement OnClockListFragmentInteractionListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnClockListFragmentInteractionListener {

        void onListFragmentInteraction(ClockItem item);
    }
}
