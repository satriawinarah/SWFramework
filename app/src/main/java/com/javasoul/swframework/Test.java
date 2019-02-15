package com.javasoul.swframework;

import android.database.sqlite.SQLiteDatabase;

import com.javasoul.swframework.database.SWStorage;
import com.javasoul.swframework.model.SWFieldColumn;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public SWFieldColumn itemId = new SWFieldColumn("item_id", new Integer(0), false, true);
    public SWFieldColumn itemName = new SWFieldColumn("item_name", new String(""), false, false);
    public SWFieldColumn itemChilds = new SWFieldColumn("item_childs", new ArrayList<Integer>(), false, false);

    public Test() {

    }

    public Test(SWFieldColumn itemId, SWFieldColumn itemName, SWFieldColumn itemChilds) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemChilds = itemChilds;
    }

    public SWFieldColumn getItemId() {
        return itemId;
    }

    public void setItemId(SWFieldColumn itemId) {
        this.itemId = itemId;
    }

    public SWFieldColumn getItemName() {
        return itemName;
    }

    public void setItemName(SWFieldColumn itemName) {
        this.itemName = itemName;
    }

    public SWFieldColumn getItemChilds() {
        return itemChilds;
    }

    public void setItemChilds(SWFieldColumn itemChilds) {
        this.itemChilds = itemChilds;
    }
}
