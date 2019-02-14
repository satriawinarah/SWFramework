package com.javasoul.swframework;

import android.app.ProgressDialog;
import android.content.Context;

public class SWProgressDialog extends ProgressDialog {

    Context context;

    public SWProgressDialog(Context context) {
        super(context);
        this.context = context;
    }

    public void showProgressIndeterminate(Boolean cancelable) {
        setMessage("Please wait...");
        setIndeterminate(true);
        setCancelable(cancelable);

        show();
    }

    public void showProgress(Boolean cancelable) {
        setMessage("Please wait...");
        setIndeterminate(false);
        setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        setCancelable(cancelable);

        show();
    }

}
