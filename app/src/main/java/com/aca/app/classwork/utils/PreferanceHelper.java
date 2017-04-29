package com.aca.app.classwork.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

/**
 * Created by ACA Student 001 on 4/29/2017.
 */

public class PreferanceHelper {
    private static final String PREFERANCE_NAME = "preferances";
    private static final String LOGGED_IN = "logged_in";
    private static final String USES_ID = "uses_id";

    private SharedPreferences preferences;

    private static PreferanceHelper instance;

    public static PreferanceHelper getInstance(Context context){
        if(instance == null){
            instance = new PreferanceHelper(context.getApplicationContext());
        }
        return instance;
    }
    private PreferanceHelper(Context context){
        preferences = context.getSharedPreferences(PREFERANCE_NAME,Context.MODE_PRIVATE);
    }

    public void resetAll(){
        final SharedPreferences.Editor editor = getEditor();
        editor.remove(LOGGED_IN);
        editor.remove(USES_ID);
        editor.apply();
    }

    private SharedPreferences.Editor getEditor(){
        return preferences.edit();
    }

    public boolean isLoggesIn() {
        return preferences.getBoolean(LOGGED_IN,false);
    }

    public void setLoggedIn(boolean loggedIn){
        final  SharedPreferences.Editor editor = getEditor();

        editor.putBoolean(LOGGED_IN,loggedIn);
        editor.apply();
    }

    public long getUserId() {
        return preferences.getLong(USES_ID,-1);
    }

    public void setUsesId(long userId){

        final SharedPreferences.Editor editor = getEditor();

        editor.putLong(USES_ID, userId);
        editor.apply();
    }
}
