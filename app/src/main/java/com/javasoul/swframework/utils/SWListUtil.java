package com.javasoul.swframework.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SWListUtil {

    public static List<Object> distinct(List<Object> objects) {
        Set<Object> newObjects = new HashSet<>();
        for(Object object: objects) {
            newObjects.add(object);
        }
        return new ArrayList<>(newObjects);
    }

}
