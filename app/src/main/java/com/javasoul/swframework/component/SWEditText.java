package com.javasoul.swframework.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.javasoul.swframework.R;

public class SWEditText extends LinearLayout {

    @StyleableRes
    int indexTitle = 0;
    @StyleableRes
    int indexDescription = 1;
    @StyleableRes
    int indexPlaceholder = 2;
    @StyleableRes
    int indexWarning = 3;
    @StyleableRes
    int indexError = 4;

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

        int[] sets = {R.attr.title, R.attr.description, R.attr.placeholder, R.attr.warning, R.attr.error};

        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);
        CharSequence title = typedArray.getText(indexTitle);
        CharSequence description = typedArray.getText(indexDescription);
        CharSequence placeholder = typedArray.getText(indexPlaceholder);
        CharSequence warning = typedArray.getText(indexWarning);
        CharSequence error = typedArray.getText(indexError);
        typedArray.recycle();

        initComponents();

        tvTitle.setText(title);
        tvDescription.setText(description);
        tvWarning.setText(warning);
        tvError.setText(error);
        txtEditText.setHint(placeholder);

        if(warning.equals("")) {
            tvWarning.setVisibility(View.GONE);
        } else {
            tvWarning.setVisibility(View.VISIBLE);
        }

        if(error.equals("")) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }

    private void initComponents() {
        tvTitle = findViewById(R.id.txt_title);
        tvDescription = findViewById(R.id.txt_description);
        tvWarning = findViewById(R.id.txt_warning);
        tvError = findViewById(R.id.txt_error);
        txtEditText = findViewById(R.id.edit_text);
    }

    public String getValue() {
        return txtEditText.getText().toString();
    }

    public String getDescription() {
        return tvDescription.getText().toString();
    }

    public String getTitle() {
        return tvTitle.getText().toString();
    }

    public String getError() {
        return tvError.getText().toString();
    }

    public String getWarning() {
        return tvWarning.getText().toString();
    }

    public void setDescription(String description) {
        tvDescription.setText(description);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setError(String error) {
        tvError.setText(error);
    }

    public void setWarning(String warning) {
        tvWarning.setText(warning);
    }

    public void setPlaceholder(String placeholder) {
        txtEditText.setHint(placeholder);
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
}