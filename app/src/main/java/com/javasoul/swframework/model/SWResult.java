package com.javasoul.swframework.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SWResult {

    private Boolean result;
    private HashMap<String, Object> data = new HashMap<>();
    private List<String> errors = new ArrayList<>();

    public SWResult() {

    }

    public SWResult(Boolean result) {
        this.result = result;
    }

    public SWResult(Boolean result, HashMap<String, Object> data, List<String> errors) {
        this.result = result;
        this.data = data;
        this.errors = errors;
    }

    public SWResult(Boolean result, List<String> errors) {
        this.result = result;
        this.errors = errors;
    }

    public SWResult(Boolean result, String error) {
        this.result = result;
        this.errors.add(error);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error) {
        this.errors.add(error);
    }

    public String getError() {
        if(this.errors.size()>0) {
            return this.errors.get(0);
        } else {
            return "";
        }
    }
}
