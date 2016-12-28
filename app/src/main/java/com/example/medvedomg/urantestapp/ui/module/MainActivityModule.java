package com.example.medvedomg.urantestapp.ui.module;

import com.example.medvedomg.urantestapp.ui.ActivityScope;
import com.example.medvedomg.urantestapp.ui.activity.MainView;
import com.example.medvedomg.urantestapp.ui.adapter.Adapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by medvedomg on 28.12.16.
 */
@Module
public class MainActivityModule {

    public MainView mMainView;


    public MainActivityModule(MainView mMainView) {
        this.mMainView = mMainView;
    }

    @Provides
    @ActivityScope
    Adapter provideAdapter(MainView mainView) {
        return new Adapter(mainView);
    }



}
