package com.example.medvedomg.urantestapp.ui.module;

import android.app.Application;
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

    public MainActivity mMainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mMainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainView provideMainView() {
        return mMainView;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mMainActivity;
    }

    @Provides
    @ActivityScope
    Adapter provideAdapter(MainActivity mainActivity) {
        return new Adapter(mainActivity);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(Application application) {
        return new LinearLayoutManager(application);
    }

    @Provides
    @ActivityScope
    MainPresenterImpl providePresenter(MainActivity mainActivity, TestdbModule testdbModule) {
        return new MainPresenterImpl(mainActivity, testdbModule);
    }

}
