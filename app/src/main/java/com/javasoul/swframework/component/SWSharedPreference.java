package com.javasoul.swframework.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.javasoul.swframework.model.SWIdValue;

import java.util.List;
import java.util.Set;

public class SWSharedPreference {

    private static Context context;
    private static String sharedPreferenceName;

    public static void init(Context ctx, String spname) {
        context = ctx;
        sharedPreferenceName = spname;
    }

    public static void save(String id, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(id, value).commit();
    }

    public static void save(String id, Boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(id, value).commit();
    }

    public static void save(String id, Integer value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(id, value).commit();
    }

    public static void save(String id, Long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong(id, value).commit();
    }

    public static void saveList(String id, Set<String> values) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putStringSet(id, values).commit();
    }

    public static void saves(List<SWIdValue> data) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(SWIdValue idValue: data) {
            editor.putString(idValue.getId(), idValue.getValue().toString());
        }
        editor.commit();
    }

    public static Boolean contains(String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.contains(id);
    }

    public static String get(String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(id, "");
    }

    public static Boolean getBoolean(String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(id, false);
    }

    public static Integer getInt(String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(id, 0);
    }

    public static Long getLong(String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(id, 0l);
    }

}
