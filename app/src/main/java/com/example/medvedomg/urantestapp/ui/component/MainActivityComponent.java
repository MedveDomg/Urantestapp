package com.example.medvedomg.urantestapp.ui.component;

import com.example.medvedomg.urantestapp.AppComponent;
import com.example.medvedomg.urantestapp.ui.ActivityScope;
import com.example.medvedomg.urantestapp.ui.activity.MainActivity;
import com.example.medvedomg.urantestapp.ui.module.MainActivityModule;

import dagger.Component;

/**
 * Created by medvedomg on 28.12.16.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {MainActivityModule.class})
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
