package com.example.medvedomg.urantestapp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.medvedomg.urantestapp.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.rv_main)
    RecyclerView mRvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void longPress() {

    }

    @Override
    public void fastPress() {

    }
}
