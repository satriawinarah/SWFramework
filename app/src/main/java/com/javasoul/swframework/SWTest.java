package com.javasoul.swframework;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.javasoul.swframework.constant.SWValidationType;
import com.javasoul.swframework.database.SWStorage;
import com.javasoul.swframework.model.SWFieldColumn;
import com.javasoul.swframework.model.SWResult;
import com.javasoul.swframework.validation.SWValidation;

import java.util.ArrayList;
import java.util.List;

public class SWTest {

    public SWFieldColumn itemId = new SWFieldColumn("item_id", new Integer(0), false, true);
    public SWFieldColumn itemName = new SWFieldColumn("item_name", new String(""), false, false);
    public SWFieldColumn itemChilds = new SWFieldColumn("item_childs", new ArrayList<Integer>(), false, false);

    public SWTest() {

    }

    public SWTest(SWFieldColumn itemId, SWFieldColumn itemName, SWFieldColumn itemChilds) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemChilds = itemChilds;
    }

    public List<SWResult> validate() {
        try {
            return SWValidation.validate(this);
        } catch(IllegalAccessException e) {
            e.printStackTrace();
            Log.e("ERROR", e.getMessage());
            return null;
        }
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
