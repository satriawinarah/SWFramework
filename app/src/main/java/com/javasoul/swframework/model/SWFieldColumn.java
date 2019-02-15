package com.javasoul.swframework.model;

public class SWFieldColumn {

    private String columnName;
    private Object value;
    private Boolean nullable = false;
    private Boolean isPrimaryKey = false;

    public SWFieldColumn() {

    }

    public SWFieldColumn(String columnName, Object value) {
        this.columnName = columnName;
        this.value = value;
    }

    public SWFieldColumn(String columnName, Object value, Boolean nullable) {
        this.columnName = columnName;
        this.value = value;
        this.nullable = nullable;
    }

    public SWFieldColumn(String columnName, Object value, Boolean nullable, Boolean isPrimaryKey) {
        this.columnName = columnName;
        this.value = value;
        this.nullable = nullable;
        this.isPrimaryKey = isPrimaryKey;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public Boolean getPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
