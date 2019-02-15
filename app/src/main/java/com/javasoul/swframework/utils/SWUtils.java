package com.javasoul.swframework.utils;

import java.lang.reflect.Field;
import java.util.HashMap;

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

    // TODO format rupiah

}
