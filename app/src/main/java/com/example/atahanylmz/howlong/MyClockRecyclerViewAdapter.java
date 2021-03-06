package com.example.atahanylmz.howlong;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.atahanylmz.howlong.ClockFragment.OnClockListFragmentInteractionListener;

import java.util.ArrayList;

public class MyClockRecyclerViewAdapter extends RecyclerView.Adapter<MyClockRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<ClockItem> mValues;
    private final OnClockListFragmentInteractionListener mListener;

    public MyClockRecyclerViewAdapter(ArrayList<ClockItem> items, OnClockListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.clock_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        //TODO Refactor these code, there are unused lines. You can do this better.
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName()); //String.valueOf(mValues.get(position).getId())
        holder.mContentView.setText(mValues.get(position).getFormattedEndDate());
        holder.mSubView.setText(String.valueOf(mValues.get(position).getIntervalInDays()) + " days left");
        holder.mPercentView.setProgress(mValues.get(position).getPercentComp());

        //TODO Use lambda notation here. Check it out in Java docs or elsewhere if you don't remember.
        //In your build.gradle for the module app you need to put these lines in android{} below buildTypes{} to enable Java 8 features.
        //Make sure that you have Java 8 in your environment.
//        compileOptions {
//            targetCompatibility 1.8
//            sourceCompatibility 1.8
//        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //TODO What if mValues is null? Think about such edge cases.
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        private final TextView mSubView;
        private final ProgressBar mPercentView;
        public ClockItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.name_area);
            mContentView = view.findViewById(R.id.rem_area);
            mSubView = view.findViewById(R.id.day_area);
            mPercentView = view.findViewById(R.id.determinateBar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
