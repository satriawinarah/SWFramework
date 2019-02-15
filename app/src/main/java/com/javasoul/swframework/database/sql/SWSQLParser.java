package com.javasoul.swframework.database.sql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

    public enum ColumnType {
        TEXT("text"),
        INTEGER("integer"),
        LONG("long");

        String columnType;

        ColumnType(String columnType) {
            this.columnType = columnType;
        }

        public String get() {
            return columnType;
        }
    }

    public static class Insert {
        String tableName;
        HashMap<String, Object> data = new HashMap<>();

        public Insert(String tableName, HashMap<String, Object> data) {
            this.tableName = tableName;
            this.data = data;
        }

        public String build() {

            StringBuilder builder = new StringBuilder();
            builder.append("insert into ");
            builder.append(tableName);
            builder.append(" ");
            builder.append(generateQueryFromList(data.keySet()));
            builder.append(" values ");
            builder.append("(");
            int index = 0;
            for(String key: data.keySet()) {
                Object value = data.get(key);

                if(value.getClass() == Integer.class) {
                    builder.append(String.valueOf(value));
                } else if(value.getClass() == String.class){
                    builder.append("'" + String.valueOf(value) + "'");
                } else if(value.getClass() == Long.class) {
                    builder.append(String.valueOf(value));
                }

                if(index+1 != data.size()) {
                    builder.append(",");
                }

                index++;
            }
            builder.append(")");

            return builder.toString();
        }

    }

    public static class CreateTable {

        String tableName;
        List<String> columns = new ArrayList<>();

        public CreateTable(String tableName) {
            this.tableName = tableName;
        }

        public CreateTable addColumn(String columnName, String columnType, Boolean nullable, Boolean isPrimaryKey) {
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

            columns.add(column.toString());

            return this;
        }

        public String build() {
            StringBuilder sqlStatement = new StringBuilder();
            sqlStatement.append("create table");
            sqlStatement.append(" ");
            sqlStatement.append(tableName);
            sqlStatement.append(" ");
            sqlStatement.append(generateQueryFromList(columns));

            return sqlStatement.toString();
        }

    }

}
