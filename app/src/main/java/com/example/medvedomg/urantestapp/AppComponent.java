package com.example.medvedomg.urantestapp;






import android.app.Application;

import com.example.medvedomg.urantestapp.data.TestdbModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by medvedomg on 22.12.16.
 */
@Singleton
@Component(modules = {AppModule.class, TestdbModule.class})
public interface AppComponent {
    TestdbModule dbHelper();
    Application application();
}
