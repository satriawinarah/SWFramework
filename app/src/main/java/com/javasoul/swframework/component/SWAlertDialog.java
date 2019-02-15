package com.javasoul.swframework.component;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.javasoul.swframework.R;

public class SWAlertDialog {

    public SWAlertDialog() {

    }

    public static void alert(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(context.getResources().getDrawable(R.drawable.ic_info));
        builder.setMessage(message);
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert1 = builder.create();
        alert1.show();
    }

}
