package com.example.medvedomg.urantestapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.medvedomg.urantestapp.ui.activity.MainView;

/**
 * Created by medvedomg on 28.12.16.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.TestViewHolder>{



    public Adapter(MainView mainView) {
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {
        public TestViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
