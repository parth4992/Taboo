package com.hopeless.taboo.datamodel;

import com.google.gson.annotations.SerializedName;

public class WordModel {
    @SerializedName("word_id")
    private int wordId;

    @SerializedName("main_word")
    private String mTitle;
    @SerializedName("taboo_word_1")
    private String mTaboo1;
    @SerializedName("taboo_word_2")
    private String mTaboo2;
    @SerializedName("taboo_word_3")
    private String mTaboo3;
    @SerializedName("taboo_word_4")
    private String mTaboo4;

    public String getTitle() {
        return mTitle;
    }

    public String getTaboo1() {
        return mTaboo1;
    }

    public String getTaboo2() {
        return mTaboo2;
    }

    public String getTaboo3() {
        return mTaboo3;
    }

    public String getTaboo4() {
        return mTaboo4;
    }

    public int getWordId() {
        return wordId;
    }
}
