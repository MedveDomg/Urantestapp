package com.example.medvedomg.urantestapp.ui.presenter;

import com.example.medvedomg.urantestapp.ui.activity.MainActivity;
import com.example.medvedomg.urantestapp.ui.activity.MainView;

/**
 * Created by medvedomg on 28.12.16.
 */

public class MainPresenterImpl {


    MainActivity mMainActivity;

    MainView mMainView;

    public static final String TAG = Class.class.getSimpleName();

    public MainPresenterImpl(MainView mMainView) {
        this.mMainView = mMainView;
    }


}
