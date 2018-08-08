package com.hopeless.taboo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by parth on 4/1/18.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String TAG = "DbHelper";
    // Database name
    private final static String DATA_BASE_NAME = "taboo.db";
    // Database version
    private final static int DATA_BASE_VER = 1;
    // Instance
    private static DbHelper sInstance;

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static  DbHelper getInstance (Context context){
        if (sInstance == null){
            sInstance = new DbHelper(context, DATA_BASE_NAME, null, DATA_BASE_VER);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(WordsTable.getCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
