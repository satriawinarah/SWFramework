package com.javasoul.swframework.utils;

import com.javasoul.swframework.model.SWFieldColumn;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SWUtils {

    public static HashMap<String, Field> getFieldsFromClass(Class cls) {
        HashMap<String, Field> fields = new HashMap<>();
        while (cls != null) {
            for (Field field : cls.getDeclaredFields()) {
                if (!fields.containsKey(field.getName())) {
                    fields.put(field.getName(), field);
                }
            }

            cls = cls.getSuperclass();
        }

        return fields;
    }

    public static List<SWFieldColumn> getFieldsFromClass(Object classObject) throws IllegalAccessException {
        Set<SWFieldColumn> fields = new HashSet<>();
        Class cls = classObject.getClass();
        while (cls != null) {
            for (Field field : classObject.getClass().getDeclaredFields()) {
                Object value = field.get(classObject);
                if(value instanceof SWFieldColumn) {
                    fields.add((SWFieldColumn) value);
                }
            }

            cls = cls.getSuperclass();
        }

        return new ArrayList<>(fields);
    }

    public static String getPriceInRupiahFormat(Long amount) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(amount);
    }

}
