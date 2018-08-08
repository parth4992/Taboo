package com.hopeless.taboo.datamodel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WordListModel {
    @SerializedName("new_words")
    ArrayList<WordModel> newWords;
    @SerializedName("old_words")
    ArrayList<WordModel> oldWords;
}
