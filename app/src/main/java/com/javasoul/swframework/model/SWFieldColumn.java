package com.javasoul.swframework.model;

import java.util.ArrayList;
import java.util.List;

public class SWFieldColumn {

    private String columnName;
    private Object value;
    private Boolean nullable = false;
    private Boolean isPrimaryKey = false;
    private Object comparedValue;
    private List<String> validationTypes = new ArrayList<>();

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

    public SWFieldColumn(String columnName, Object value, Boolean nullable, Boolean isPrimaryKey, Object comparedValue, List<String> validationTypes) {
        this.columnName = columnName;
        this.value = value;
        this.nullable = nullable;
        this.isPrimaryKey = isPrimaryKey;
        this.comparedValue = comparedValue;
        this.validationTypes = validationTypes;
    }

    public Object getComparedValue() {
        return comparedValue;
    }

    public void setComparedValue(Object comparedValue) {
        this.comparedValue = comparedValue;
    }

    public List<String> getValidationTypes() {
        return validationTypes;
    }

    public void setValidationTypes(List<String> validationTypes) {
        this.validationTypes = validationTypes;
    }

    public void addValidationTypes(String validationType) {
        this.validationTypes.add(validationType);
    }

    public void addValidationTypes(String... validationTypes) {
        for(String validationType: validationTypes) {
            this.validationTypes.add(validationType);
        }
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
