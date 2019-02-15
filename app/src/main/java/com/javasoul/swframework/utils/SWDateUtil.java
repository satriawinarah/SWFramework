package com.javasoul.swframework.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SWDateUtil {

    public static String dateToStringDefault(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date stringToDateDefault(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        }catch(ParseException e) {
            return null;
        }
    }

    public static String dateToString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static Date stringToDate(String dateString, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateString);
        }catch(ParseException e) {
            return null;
        }
    }

    public static int getYearNow() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMonthNow() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getDayNow() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    public static String getMonthName(int month) {
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        return months[month];
    }

    public static String getDayName(Date date) {
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }

}
