package com.javasoul.swframework.component;

import android.util.Log;

public class SWLog {

    public static void e(Class cls, String message) {
        int lineNumber = Thread.currentThread().getStackTrace()[0].getLineNumber();
        Log.e(cls.getSimpleName() + ": " + lineNumber, "Error : " + message);
    }

    public static void e(Class cls, String functionName, String message) {
        int lineNumber = Thread.currentThread().getStackTrace()[0].getLineNumber();
        Log.e(cls.getSimpleName() + "." + functionName + "():" + lineNumber, "Error : " + message);
    }

    public static void d(Class cls, String message) {
        int lineNumber = Thread.currentThread().getStackTrace()[0].getLineNumber();
        Log.e(cls.getSimpleName() + ": " + lineNumber, "Debug : " + message);
    }

    public static void d(Class cls, String functionName, String message) {
        int lineNumber = Thread.currentThread().getStackTrace()[0].getLineNumber();
        Log.e(cls.getSimpleName() + "." + functionName + "():" + lineNumber, "Debug : " + message);
    }

}
