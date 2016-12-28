package com.example.medvedomg.urantestapp;



import android.app.Application;

import com.example.medvedomg.urantestapp.data.TestdbModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .testdbModule(new TestdbModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
