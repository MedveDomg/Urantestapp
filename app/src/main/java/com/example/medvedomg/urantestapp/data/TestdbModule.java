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

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "testdb";
    private static final String TABLE_FILES = "files";

    private static final String FILE_ID = "id";

    private static final String FILE_NAME = "filename";

    private static final String FILE_BAR = "bartype";

    private static final String FILE_DATA_MODIFIED = "data";


    private Context mContext;

    String CREATE_FILES_TABLE = "CREATE TABLE " + TABLE_FILES + "("

            + FILE_ID + " INTEGER PRIMARY KEY," + FILE_NAME + " TEXT,"

            + FILE_BAR + " TEXT," + FILE_DATA_MODIFIED + " TEXT" + ")";


    public TestdbModule(Context context) {
        super(context, "testdb", null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FILES_TABLE);

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
