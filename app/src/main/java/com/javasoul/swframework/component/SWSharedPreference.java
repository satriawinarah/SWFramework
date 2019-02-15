package com.javasoul.swframework.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.javasoul.swframework.model.SWIdValue;

import java.util.List;
import java.util.Set;

public class SWSharedPreference {

    public static void save(Context context, String sharedPreferenceName, String id, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(id, value).commit();
    }

    public static void saveList(Context context, String sharedPreferenceName, String id, Set<String> values) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putStringSet(id, values).commit();
    }

    public static void saves(Context context, String sharedPreferenceName, List<SWIdValue> data) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(SWIdValue idValue: data) {
            editor.putString(idValue.getId(), idValue.getValue().toString());
        }
        editor.commit();
    }

    public static String get(Context context, String sharedPreferenceName, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(id, "");
    }

}
