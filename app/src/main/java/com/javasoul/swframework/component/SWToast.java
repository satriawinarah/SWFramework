package com.javasoul.swframework.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.javasoul.swframework.R;

public class SWToast {

    private static Context context;

    public SWToast() {

    }

    public static void init(Context ctx) {
        context = ctx;
    }

    public static void showShortError(String error) {
        showError(Toast.LENGTH_SHORT, error);
    }

    public static void showLongError(String error) {
        showError(Toast.LENGTH_LONG, error);
    }

    public static void showError(int duration, String error) {
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

    public static void showShortInfo(String info) {
        showInfo(Toast.LENGTH_SHORT, info);
    }

    public static void showLongInfo(String info) {
        showInfo(Toast.LENGTH_LONG, info);
    }

    public static void showInfo(int duration, String info) {
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

    public static void showShortWarning(String warning) {
        showWarning(Toast.LENGTH_SHORT, warning);
    }

    public static void showLongWarning(String warning) {
        showWarning(Toast.LENGTH_LONG, warning);
    }

    public static void showWarning(int duration, String warning) {
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

    public static void showSaveSuccess() {
        showSuccess(Toast.LENGTH_SHORT, "Save");
    }

    public static void showDeleteSuccess() {
        showSuccess(Toast.LENGTH_SHORT, "Delete");
    }

    public static void showUpdateSuccess() {
        showSuccess(Toast.LENGTH_SHORT, "Update");
    }

    public static void showSuccess(int duration, String prefix) {
        View view = LayoutInflater.from(context).inflate(R.layout.sw_toast, null, false);
        view.setBackground(context.getResources().getDrawable(R.drawable.toast_background_success));

        ImageView icon = view.findViewById(R.id.toast_icon);
        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_success));
        TextView message = view.findViewById(R.id.toast_message);
        message.setText(prefix + " success");
        message.setTextColor(context.getResources().getColor(android.R.color.white));

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

    public static void showSaveFailed() {
        showFailed(Toast.LENGTH_SHORT, "Save");
    }

    public static void showDeleteFailed() {
        showFailed(Toast.LENGTH_SHORT, "Delete");
    }

    public static void showUpdateFailed() {
        showFailed(Toast.LENGTH_SHORT, "Update");
    }

    public static void showFailed(int duration, String prefix) {
        View view = LayoutInflater.from(context).inflate(R.layout.sw_toast, null, false);
        view.setBackground(context.getResources().getDrawable(R.drawable.toast_background_error));

        ImageView icon = view.findViewById(R.id.toast_icon);
        icon.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_failed));
        TextView message = view.findViewById(R.id.toast_message);
        message.setText(prefix + " failed");
        message.setTextColor(context.getResources().getColor(android.R.color.white));

        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }

    public static void showDefaultShort(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showDefaultLong(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
