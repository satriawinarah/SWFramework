package com.javasoul.swframework.model;

import java.util.ArrayList;
import java.util.List;

public class SWValidationModel {

    private String name;
    private Object value;
    private Object comparedValue;
    private List<String> validationTypes = new ArrayList<>();

    public SWValidationModel() {

    }

    public SWValidationModel(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public SWValidationModel(String name, Object value, List<String> validationTypes) {
        this.name = name;
        this.value = value;
        this.validationTypes = validationTypes;
    }

    public SWValidationModel(String name, Object value, Object comparedValue, List<String> validationTypes) {
        this.name = name;
        this.value = value;
        this.comparedValue = comparedValue;
        this.validationTypes = validationTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getComparedValue() {
        return comparedValue;
    }

    public void setComparedValue(Object comparedValue) {
        this.comparedValue = comparedValue;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<String> getValidationTypes() {
        return validationTypes;
    }

    public void setValidationTypes(List<String> validationTypes) {
        this.validationTypes = validationTypes;
    }

    public enum ValidationType {
        ZERO,
        NEGATIVE,
        COMPARE;
    }

}
