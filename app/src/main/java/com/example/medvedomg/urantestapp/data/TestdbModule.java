package com.example.medvedomg.urantestapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.medvedomg.urantestapp.ui.model.FileModel;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by medvedomg on 28.12.16.
 */

@Module
public class TestdbModule extends SQLiteOpenHelper {

    public static final String TAG = Class.class.getSimpleName();

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "testdb";
    private static final String TABLE_FILES = "files";

    private static final String FILE_ID = "id";

    private static final String FILE_NAME = "filename";

    private static final String FILE_BAR = "bartype";

    private static final String FILE_DATA_MODIFIED = "data";


    private Context mContext;

    ArrayList<FileModel> list = new ArrayList<>();

    String CREATE_FILES_TABLE = "CREATE TABLE " + TABLE_FILES + "("

            + FILE_ID + " INTEGER PRIMARY KEY," + FILE_NAME + " TEXT,"

            + FILE_BAR + " TEXT," + FILE_DATA_MODIFIED + " TEXT" + ")";
    private SQLiteDatabase db;
    private FileModel fileModel;
    private ContentValues cv;


    public TestdbModule(Context context) {
        super(context, "testdb", null, 1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FILES_TABLE);
        insertFileModels(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertFileModels(SQLiteDatabase db) {
        cv = new ContentValues();
        for (int i = 0; i < 10; i++) {

            cv.put(FILE_NAME, "SOBAKA" + i);
            cv.put(FILE_BAR, "orange");
            cv.put(FILE_DATA_MODIFIED, "18.29.2016");
            db.insert(TABLE_FILES, null, cv);
            Log.d(TAG, "insreted one row in db");
        }
    }
    public ArrayList<FileModel> getFiles(SQLiteDatabase db) {
        fileModel = new FileModel();
        Cursor c = db.query(TABLE_FILES, null, null, null, null, null, null);
        if (c.moveToFirst()) {
           int nameIndex =  c.getColumnIndex(FILE_NAME);
            int barIndex = c.getColumnIndex(FILE_BAR);
            int modifiedIndex = c.getColumnIndex(FILE_DATA_MODIFIED);
            while (c.moveToNext()) {
                fileModel.setFileName(c.getString(nameIndex));
                boolean chectBar = c.getString(barIndex).equals("orange") ? true : false;
                fileModel.setOrange(chectBar);
                list.add(fileModel);
                Log.d(TAG, "added FileModel");
            }
        }
        return list;
    }

    @Provides
    @Singleton
    TestdbModule provideHelperModule() {
        return new TestdbModule(mContext);
    }
}
