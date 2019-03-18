package com.javasoul.swframework.component;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.javasoul.swframework.R;

public class SWDialog {

    public SWDialog() {

    }

    public interface YesNoCallback {
        void yes();
        void no();
    }

    public interface ListCallback {
        void onItemClick(Object object);
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

    public static void simpleYesNoDialog(Context context, String question, final YesNoCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(context.getResources().getDrawable(R.drawable.ic_info));
        builder.setMessage(question);
        builder.setCancelable(false);

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        callback.yes();
                    }
                });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callback.no();
            }
        });

        AlertDialog alert1 = builder.create();
        alert1.show();
    }

    public static void error(Context context, String title, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.sw_dialog);
        dialog.setCancelable(false);

        RelativeLayout header = dialog.findViewById(R.id.rl_dialog_header);
        header.setBackgroundColor(context.getResources().getColor(R.color.colorDarkRed));
        TextView titleDialog = dialog.findViewById(R.id.tv_dialog_title);
        titleDialog.setTextColor(context.getResources().getColor(android.R.color.white));
        titleDialog.setText(title);
        TextView messageDialog = dialog.findViewById(R.id.tv_error_message);
        messageDialog.setText(message);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void info(Context context, String title, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.sw_dialog);
        dialog.setCancelable(false);

        RelativeLayout header = dialog.findViewById(R.id.rl_dialog_header);
        header.setBackgroundColor(context.getResources().getColor(R.color.colorDarkBlue));
        TextView titleDialog = dialog.findViewById(R.id.tv_dialog_title);
        titleDialog.setText(title);
        titleDialog.setTextColor(context.getResources().getColor(android.R.color.white));
        TextView messageDialog = dialog.findViewById(R.id.tv_error_message);
        messageDialog.setText(message);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void warning(Context context, String title, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.sw_dialog);
        dialog.setCancelable(false);

        RelativeLayout header = dialog.findViewById(R.id.rl_dialog_header);
        header.setBackgroundColor(context.getResources().getColor(R.color.colorYellow));
        TextView titleDialog = dialog.findViewById(R.id.tv_dialog_title);
        titleDialog.setText(title);
        titleDialog.setTextColor(context.getResources().getColor(android.R.color.black));
        TextView messageDialog = dialog.findViewById(R.id.tv_error_message);
        messageDialog.setText(message);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void custom(Context context, int headerColor, int titleColor, String title, String message) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.sw_dialog);
        dialog.setCancelable(false);

        RelativeLayout header = dialog.findViewById(R.id.rl_dialog_header);
        header.setBackgroundColor(context.getResources().getColor(headerColor));
        TextView titleDialog = dialog.findViewById(R.id.tv_dialog_title);
        titleDialog.setText(title);
        titleDialog.setTextColor(context.getResources().getColor(titleColor));
        TextView messageDialog = dialog.findViewById(R.id.tv_error_message);
        messageDialog.setText(message);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static void customYesNo(Context context, int headerColor, int titleColor, String title, String message, final YesNoCallback callback) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.sw_dialog);
        dialog.setCancelable(false);

        RelativeLayout header = dialog.findViewById(R.id.rl_dialog_header);
        header.setBackgroundColor(context.getResources().getColor(headerColor));
        TextView titleDialog = dialog.findViewById(R.id.tv_dialog_title);
        titleDialog.setText(title);
        titleDialog.setTextColor(context.getResources().getColor(titleColor));
        TextView messageDialog = dialog.findViewById(R.id.tv_error_message);
        messageDialog.setText(message);
        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        btnCancel.setVisibility(View.GONE);
        LinearLayout layoutYesNo = dialog.findViewById(R.id.ll_yes_no);
        layoutYesNo.setVisibility(View.VISIBLE);

        Button btnYes = dialog.findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.yes();
            }
        });

        Button btnNo = dialog.findViewById(R.id.btn_no);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.no();
            }
        });

        dialog.show();
    }

}
