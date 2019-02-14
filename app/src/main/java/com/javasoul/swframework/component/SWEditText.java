package com.javasoul.swframework.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.javasoul.swframework.R;

public class SWEditText {

    private View swEditText;

    private int id;
    private String code;

    private TextView txtTitle;
    private TextView txtError;
    private TextView txtWarning;
    private TextView txtDescription;

    private EditText editText;

    public SWEditText(Context context, int id) {
        this.id = id;
        define(context);
    }

    public SWEditText(Context context, String code) {
        this.code = code;
        define(context);
    }

    public SWEditText(Context context) {
        define(context);
    }

    private void define(Context context) {
        swEditText = LayoutInflater.from(context).inflate(R.layout.sw_edit_text, null, false);

        txtTitle = swEditText.findViewById(R.id.txt_title);
        txtError = swEditText.findViewById(R.id.txt_error);
        txtWarning = swEditText.findViewById(R.id.txt_warning);
        txtDescription = swEditText.findViewById(R.id.txt_description);
        editText = swEditText.findViewById(R.id.edit_text);
    }

    public View build() {
        return swEditText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        editText.setText(value);
    }

    public String getValue() {
        return editText.getText().toString();
    }

    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    public String getTitle() {
        return txtTitle.getText().toString();
    }

    public void setError(String error) {
        txtError.setText(error);
    }

    public String getError() {
        return txtError.getText().toString();
    }

    public void setWarning(String warning) {
        txtWarning.setText(warning);
    }

    public String getWarning() {
        return txtWarning.getText().toString();
    }

    public void setDescription(String description) {
        txtDescription.setText(description);
    }

    public String getDescription() {
        return txtDescription.getText().toString();
    }

    public void setHint(String hint) {
        editText.setHint(hint);
    }

}
