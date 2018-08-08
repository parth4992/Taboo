package utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.hopeless.taboo.MainApplication;

public class Utils {

    private static final String SHARED_PREF = "TabooSharedPref";

    public static void saveToSharedPref(String key, int value){
        SharedPreferences sharedPref = MainApplication.getContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        sharedPref.edit().putInt(key,value).apply();
    }

    public static int getIntFromSharedPref(String key){
        SharedPreferences sharedPref = MainApplication.getContext().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        return sharedPref.getInt(key, -1);
    }


}
