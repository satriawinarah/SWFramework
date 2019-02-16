package com.javasoul.swframework.database;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public abstract class SWStorage<T> {

    public SQLiteDatabase db;

    public SWStorage(SQLiteDatabase db) {
        this.db = db;
    }

    public abstract List<T> getAll();

    public abstract T getDataById(T id);

    public abstract long insert(T data);

    public abstract long update(T data);

    public abstract long delete(T id);

}
