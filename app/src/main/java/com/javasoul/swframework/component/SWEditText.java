package com.javasoul.swframework.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javasoul.swframework.R;

public class SWEditText extends LinearLayout {

    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvError;
    private TextView tvWarning;

    private EditText txtEditText;

    public SWEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.sw_edit_text, this);

        String title = "";
        String description = "";
        String warning = "";
        String error = "";
        String placeholder = "";

        for(int i=0; i<attrs.getAttributeCount(); i++) {
            String name = attrs.getAttributeName(i);
            String value = attrs.getAttributeValue(i);

            if(name.equals(getResources().getResourceName(R.attr.title))){
                title = value;
            } else if(name.equals("description")) {
                description = value;
            } else if(name.equals("warning")) {
                warning = value;
            } else if(name.equals("placeholder")) {
                placeholder = value;
            } else if(name.equals("error")) {
                error = value;
            }
        }

        initComponents();

        tvTitle.setText(title);
        tvDescription.setText(description);
        tvWarning.setText(warning);
        tvError.setText(error);
        txtEditText.setHint(placeholder);

        changeComponentVisibility(tvTitle, title==null?"":title);
        changeComponentVisibility(tvDescription, description==null?"":description);
        changeComponentVisibility(tvError, error==null?"":error);
        changeComponentVisibility(tvWarning, warning==null?"":warning);
    }

    private void initComponents() {
        tvTitle = findViewById(R.id.txt_title);
        tvDescription = findViewById(R.id.txt_description);
        tvWarning = findViewById(R.id.txt_warning);
        tvError = findViewById(R.id.txt_error);
        txtEditText = findViewById(R.id.edit_text);
    }

    public String getValue() {
        return txtEditText.getText()==null?"":txtEditText.getText().toString();
    }

    public String getDescription() {
        return tvDescription.getText()==null?"":tvDescription.getText().toString();
    }

    public String getTitle() {
        return tvTitle.getText()==null?"":tvTitle.getText().toString();
    }

    public String getError() {
        return tvError.getText()==null?"":tvError.getText().toString();
    }

    public String getWarning() {
        return tvWarning.getText()==null?"":tvWarning.getText().toString();
    }

    public void setDescription(String description) {
        tvDescription.setText(description);
        changeComponentVisibility(tvDescription, description);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
        changeComponentVisibility(tvTitle, title);
    }

    public void setError(String error) {
        tvError.setText(error);
        changeComponentVisibility(tvError, error);
    }

    public void setWarning(String warning) {
        tvWarning.setText(warning);
        changeComponentVisibility(tvWarning, warning);
    }

    public void setPlaceholder(String placeholder) {
        txtEditText.setHint(placeholder);
    }

    public void setValue(String value) {
        txtEditText.setText(value);
    }

    public String getPlaceholder() {
        return txtEditText.getHint().toString();
    }

    public TextView getTitleComponent() {
        return tvTitle;
    }

    public TextView getDescriptionComponent() {
        return tvDescription;
    }

    public TextView getErrorComponent() {
        return tvError;
    }

    public TextView getWarningComponent() {
        return tvWarning;
    }

    public EditText getEditText() {
        return txtEditText;
    }

    private void changeComponentVisibility(TextView textView, String value) {
        if(value==null || value.equals("")) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
        }
    }
}