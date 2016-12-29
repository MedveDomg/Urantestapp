package com.example.medvedomg.urantestapp.ui.presenter;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.medvedomg.urantestapp.data.TestdbModule;
import com.example.medvedomg.urantestapp.ui.activity.MainActivity;
import com.example.medvedomg.urantestapp.ui.activity.MainView;
import com.example.medvedomg.urantestapp.ui.model.FileModel;

import java.util.ArrayList;

/**
 * Created by medvedomg on 28.12.16.
 */

public class MainPresenterImpl implements MainPresenter{


    MainActivity mMainActivity;

    MainView mMainView;

    ArrayList<FileModel> list = new ArrayList<>();

    public static final String TAG = Class.class.getSimpleName();

    TestdbModule testdbModule;

    public MainPresenterImpl(MainActivity mMainActivity, TestdbModule testdbModule) {
        this.mMainView = mMainView;
        this.mMainActivity = mMainActivity;
        this.testdbModule = testdbModule;
    }


    @Override
    public void loadData() {
        SQLiteDatabase db =  testdbModule.getReadableDatabase();
        list = testdbModule.getFiles(db);
        Log.d(TAG, list.size() + "");
        mMainActivity.setFiles(list);
    }
}
