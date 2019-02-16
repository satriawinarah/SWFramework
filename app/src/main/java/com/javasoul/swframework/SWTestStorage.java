package com.javasoul.swframework;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.javasoul.swframework.database.SWSQLParser;
import com.javasoul.swframework.database.SWStorage;

import java.util.List;

public class SWTestStorage extends SWStorage {

    public SWTestStorage(SQLiteDatabase db) {
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
        try {
            ContentValues contentValues = new SWSQLParser.Insert("test", data).build();
            return db.insert("test", null, contentValues);
        }catch(IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long update(Object data) {
        try {
            SWTest test = (SWTest) data;
            ContentValues contentValues = new SWSQLParser.Insert("test", data).build(test.getItemId(), test.getItemChilds());
            return db.update("test", contentValues, "", null);
        }catch(IllegalAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public long delete(Object id) {
        return 0;
    }

    public String createTable() {
        try {
            return new SWSQLParser.CreateTable("test", new SWTest()).build();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
            return "";
        }
    }

}
