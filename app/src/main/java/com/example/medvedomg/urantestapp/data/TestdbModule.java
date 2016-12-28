package com.example.medvedomg.urantestapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by medvedomg on 28.12.16.
 */

@Module
public class TestdbModule extends SQLiteOpenHelper {


    Context mContext;


    public TestdbModule(Context context) {
        super(context, "testdb", null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Provides
    @Singleton
    TestdbModule provideHelperModule() {
        return new TestdbModule(mContext);
    }
}
