package com.javasoul.swframework.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.javasoul.swframework.R;

public class SWToast {

    public SWToast() {

    }

    public static void showShortError(Context context, String error) {
        showError(context, Toast.LENGTH_SHORT, error);
    }

    public static void showLongError(Context context, String error) {
        showError(context, Toast.LENGTH_LONG, error);
    }

    private static void showError(Context context, int duration, String error) {
        View view = LayoutInflater.from(context).inflate(R.layout.sw_toast, null, false);
        view.setBackground(context.getResources().getDrawable(R.drawable.toast_background_error));

        ImageView icon = view.findViewById(R.id.toast_icon);
        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_error));
        TextView message = view.findViewById(R.id.toast_message);
        message.setText(error);
        message.setTextColor(context.getResources().getColor(android.R.color.white));

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

    public static void showShortInfo(Context context, String info) {
        showInfo(context, Toast.LENGTH_SHORT, info);
    }

    public static void showLongInfo(Context context, String info) {
        showInfo(context, Toast.LENGTH_LONG, info);
    }

    private static void showInfo(Context context, int duration, String info) {
        View view = LayoutInflater.from(context).inflate(R.layout.sw_toast, null, false);
        view.setBackground(context.getResources().getDrawable(R.drawable.toast_background_info));

        ImageView icon = view.findViewById(R.id.toast_icon);
        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_info));
        TextView message = view.findViewById(R.id.toast_message);
        message.setText(info);
        message.setTextColor(context.getResources().getColor(android.R.color.white));

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

    public static void showShortWarning(Context context, String warning) {
        showWarning(context, Toast.LENGTH_SHORT, warning);
    }

    public static void showLongWarning(Context context, String warning) {
        showWarning(context, Toast.LENGTH_LONG, warning);
    }

    private static void showWarning(Context context, int duration, String warning) {
        View view = LayoutInflater.from(context).inflate(R.layout.sw_toast, null, false);
        view.setBackground(context.getResources().getDrawable(R.drawable.toast_background_warning));

        ImageView icon = view.findViewById(R.id.toast_icon);
        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_warning));
        TextView message = view.findViewById(R.id.toast_message);
        message.setText(warning);
        message.setTextColor(context.getResources().getColor(android.R.color.black));

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

}
