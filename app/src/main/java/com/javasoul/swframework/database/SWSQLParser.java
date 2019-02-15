package com.javasoul.swframework.database;

import android.content.ContentValues;

import com.javasoul.swframework.model.SWFieldColumn;
import com.javasoul.swframework.utils.SWUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SWSQLParser {

    public static String generateQueryFromList(Collection<String> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        int columnsLength = list.size();
        int index = 0;
        for(String data: list) {
            builder.append(data);

            if(index+1 != columnsLength) {
                builder.append(",");
            }

            index++;
        }
        builder.append(")");

        return builder.toString();
    }

    public static String parseColumnType(Object object) {
        if(object instanceof Integer) {
            return "integer";
        } else if(object instanceof String) {
            return "text";
        } else {
            return "text";
        }
    }

    public static class CreateTable {

        String tableName;
        Object classObject;

        public CreateTable(String tableName, Object classObject) {
            this.tableName = tableName;
            this.classObject = classObject;
        }

        public String build() throws IllegalAccessException{
            StringBuilder statement = new StringBuilder();
            List<SWFieldColumn> fields = getFieldsFromClass(classObject);
            List<String> columns = new ArrayList<>();

            for(SWFieldColumn field: fields) {
                String columnName = field.getColumnName();
                String columnType = parseColumnType(field.getValue());
                Boolean nullable = field.getNullable();
                Boolean isPrimaryKey = field.getPrimaryKey();

                columns.add(addColumn(columnName, columnType, nullable, isPrimaryKey));
            }

            statement.append("create table");
            statement.append(" ");
            statement.append(tableName);
            statement.append(" ");
            statement.append(generateQueryFromList(columns));

            return statement.toString();
        }

        public String addColumn(String columnName, String columnType, Boolean nullable, Boolean isPrimaryKey) {
            StringBuilder column = new StringBuilder();
            column.append(columnName.replace(" ", "").trim());
            column.append(" ");
            column.append(columnType.replace(" ", "").trim());
            if(isPrimaryKey) {
                column.append(" ");
                column.append("primary key autoincrement");
            }
            if(!nullable) {
                column.append(" ");
                column.append("not null");
            }

            return column.toString();
        }

        public List<SWFieldColumn> getFieldsFromClass(Object classObject) throws IllegalAccessException {
            Set<SWFieldColumn> fields = new HashSet<>();
            Class cls = classObject.getClass();
            while (cls != null) {
                for (Field field : classObject.getClass().getDeclaredFields()) {
                    Object value = field.get(classObject);
                    fields.add((SWFieldColumn) value);
                }

                cls = cls.getSuperclass();
            }

            return new ArrayList<>(fields);
        }

    }

}
