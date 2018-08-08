package com.hopeless.taboo.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hopeless.taboo.MainApplication;
import com.hopeless.taboo.datamodel.WordModel;

import java.util.ArrayList;

/**
 * Created by parth on 4/1/18.
 */

public class WordsTable {

    private static final String TABLE_NAME = "WordsTable";

    private static final String COLUMN_WORD_ID = "main_word_id";
    private static final String COLUMN_MAIN_WORD = "main_word";
    private static final String COLUMN_TABOO_FIRST = "taboo_first_word";
    private static final String COLUMN_TABOO_SECOND = "taboo_second_word";
    private static final String COLUMN_TABOO_THIRD = "taboo_third_word";
    private static final String COLUMN_TABOO_FOURTH = "taboo_fourth_word";
    private static final String COLUMN_WORD_USED = "word_used";
    private final static String[][] TABLE_FIELDS = new String[][]{
            {COLUMN_WORD_ID, "INTEGER"},
            {COLUMN_MAIN_WORD, "VARCHAR"},
            {COLUMN_TABOO_FIRST, "VARCHAR"},
            {COLUMN_TABOO_SECOND, "VARCHAR"},
            {COLUMN_TABOO_THIRD, "VARCHAR"},
            {COLUMN_TABOO_FOURTH, "VARCHAR"},
            {COLUMN_WORD_USED, "INTEGER"}
    };
    private static final String TAG = "WordsTable";

    SQLiteDatabase mDatabase;
    DbHelper dbHelper;
    static WordsTable table;

    private WordsTable(){
        dbHelper = DbHelper.getInstance(MainApplication.getContext());
        mDatabase = dbHelper.getWritableDatabase();
    }
    public static WordsTable getInstance(){
        if (table == null) {
            table = new WordsTable();
        }
        return table;
    }

    public static String getCreateQuery(){
        StringBuilder sb = new StringBuilder();
        StringBuilder tableParams = new StringBuilder();
        for (int i = 0; i < TABLE_FIELDS.length; i++) {
            tableParams.append(TABLE_FIELDS[i][0]).append(" ").append(TABLE_FIELDS[i][1]);
            if (i < (TABLE_FIELDS.length - 1)) {
                tableParams.append(", ");
            }
        }
        sb.append("CREATE TABLE ").append(TABLE_NAME).append(" (").append(tableParams.toString())
                .append(")");
        return sb.toString();
    }

    public void insertWord(ArrayList<WordModel> list){
        mDatabase.beginTransaction();
        for (WordModel word : list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_WORD_ID, word.getWordId());
            cv.put(COLUMN_MAIN_WORD, word.getTitle());
            cv.put(COLUMN_TABOO_FIRST, word.getTaboo1());
            cv.put(COLUMN_TABOO_SECOND, word.getTaboo2());
            cv.put(COLUMN_TABOO_THIRD, word.getTaboo3());
            cv.put(COLUMN_TABOO_FOURTH, word.getTaboo4());
            cv.put(COLUMN_WORD_USED, 0);
            mDatabase.insert(TABLE_NAME, null, cv);
        }
        mDatabase.setTransactionSuccessful();
         mDatabase.endTransaction();
    }

    public void deleteWord(WordModel model){
        if(model == null){
            Log.e(TAG, "Delete :: word model is null");
            return;
        }
        mDatabase.delete(TABLE_NAME, "COLUMN_WORD_ID = " + model.getWordId(), null);
    }
}
