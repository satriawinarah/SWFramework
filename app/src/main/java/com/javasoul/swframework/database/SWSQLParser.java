package com.javasoul.swframework.database;

import android.content.ContentValues;

import com.javasoul.swframework.model.SWFieldColumn;
import com.javasoul.swframework.utils.SWUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public static class Insert {

        String tableName;
        Object classObject;

        public Insert(String tableName, Object classObject) {
            this.tableName = tableName;
            this.classObject = classObject;
        }

        public ContentValues build() throws IllegalAccessException {
            List<SWFieldColumn> fields = SWUtils.getFieldsFromClass(classObject);
            ContentValues contentValues = new ContentValues();

            for(SWFieldColumn field: fields) {
                contentValues.put(field.getColumnName(), field.getValue().toString());
            }

            return contentValues;
        }

        public ContentValues build(SWFieldColumn... fields) throws IllegalAccessException {
            ContentValues contentValues = new ContentValues();

            for(SWFieldColumn field: fields) {
                contentValues.put(field.getColumnName(), field.getValue().toString());
            }

            return contentValues;
        }

    }

    public static class Update {

        String tableName;
        Object classObject;

        public Update(String tableName, Object classObject) {
            this.tableName = tableName;
            this.classObject = classObject;
        }

        public ContentValues build() throws IllegalAccessException {
            List<SWFieldColumn> fields = SWUtils.getFieldsFromClass(classObject);
            ContentValues contentValues = new ContentValues();

            for(SWFieldColumn field: fields) {
                contentValues.put(field.getColumnName(), field.getValue().toString());
            }

            return contentValues;
        }

        public ContentValues build(SWFieldColumn... fields) throws IllegalAccessException {
            ContentValues contentValues = new ContentValues();

            for(SWFieldColumn field: fields) {
                contentValues.put(field.getColumnName(), field.getValue().toString());
            }

            return contentValues;
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
            List<SWFieldColumn> fields = SWUtils.getFieldsFromClass(classObject);
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

    }

}
