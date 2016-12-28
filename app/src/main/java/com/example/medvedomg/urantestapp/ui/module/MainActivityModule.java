package com.example.medvedomg.urantestapp.ui.module;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.example.medvedomg.urantestapp.data.TestdbModule;
import com.example.medvedomg.urantestapp.ui.ActivityScope;
import com.example.medvedomg.urantestapp.ui.activity.MainActivity;
import com.example.medvedomg.urantestapp.ui.activity.MainView;
import com.example.medvedomg.urantestapp.ui.adapter.Adapter;
import com.example.medvedomg.urantestapp.ui.presenter.MainPresenterImpl;

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
    MainView provideMainView() {
        return mMainView;
    }

    @Provides
    @ActivityScope
    Adapter provideAdapter(MainView mainView) {
        return new Adapter(mainView);
    }

    @Provides
    @ActivityScope
    Context provideContext() {
        return new MainActivity().getApplicationContext();
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    @ActivityScope
    MainPresenterImpl providePresenter(MainView mainView, TestdbModule testdbModule) {
        return new MainPresenterImpl(mainView, testdbModule);
    }

}
