package com.hopeless.taboo.db;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.hopeless.taboo.datamodel.WordListModel;
import com.hopeless.taboo.datamodel.WordModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DbUpdaterThread extends Thread {
    private final String TAG = "DbUpdaterThread";
    Context context;

    DbUpdaterThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        super.run();
        try {
            InputStream stream = context.getAssets().open("NewTabooWords.json");
            if (stream == null)
                return;
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            String json = new String(buffer, "UTF-8");

            Gson gson = new Gson();
            ArrayList<WordModel> words = new ArrayList<>();
            words = gson.fromJson(json, words.getClass());
            WordsTable wordsTable = WordsTable.getInstance();
            wordsTable.insertWord(words);
        } catch (IOException e) {
            Log.e(TAG, "Unable to open file");

            e.printStackTrace();
            return;
        }
    }
}
