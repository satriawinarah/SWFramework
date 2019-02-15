package com.javasoul.swframework;

import android.database.sqlite.SQLiteDatabase;

import com.javasoul.swframework.database.SWStorage;

import java.util.List;

public class Test extends SWStorage {

    public Test(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getDataById(Object id) {
        return null;
    }

    @Override
    public long insert(Object data) {
        return 0;
    }

    @Override
    public long update(Object data) {
        return 0;
    }

    @Override
    public long delete(Object id) {
        return 0;
    }
}
