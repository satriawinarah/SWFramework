package com.javasoul.swframework.model;

public class SWIdValue {

    private String id;
    private Object value;

    public SWIdValue() {

    }

    public SWIdValue(String id, Object value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
