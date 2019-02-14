package com.javasoul.swframework.validation;

import com.javasoul.swframework.model.SWResult;
import com.javasoul.swframework.model.SWValidationModel;

import java.util.ArrayList;
import java.util.List;

public class SWValidation {

    public static List<SWResult> validate(List<SWValidationModel> models) {
        List<SWResult> results = new ArrayList<>();

        for (SWValidationModel model : models) {
            SWResult result = checkNullAndEmpty(model.getName(), model.getValue());
            if(result.getResult()) {
                results.add(validateWithValidationType(model));
            } else {
                results.add(result);
            }

        }
        return results;
    }

    private static SWResult validateWithValidationType(SWValidationModel model) {
        String name = model.getName();
        Object value = model.getValue();
        Object comparedValue = model.getComparedValue();
        List<String> validationTypes = model.getValidationTypes();

        for(String validationType: validationTypes) {
            if(validationType.equals(SWValidationModel.ValidationType.COMPARE.toString())) {
                if(!comparedValue.toString().equals(value.toString())) {
                    return new SWResult(false, name + " must equal to " + comparedValue.toString());
                }
            }

            if(value instanceof Integer || value instanceof Long) {
                if(validationType.equals(SWValidationModel.ValidationType.NEGATIVE.toString())) {
                    if(Integer.parseInt(value.toString())<0) {
                        return new SWResult(false, name + " must not negative");
                    }
                }

                if(validationType.equals(SWValidationModel.ValidationType.ZERO.toString())) {
                    if(Integer.parseInt(value.toString())==0) {
                        return new SWResult(false, name + " must greater than zero");
                    }
                }
            }
        }

        return new SWResult(true);
    }

    private static SWResult checkNullAndEmpty(String name, Object value) {
        if(value == null) {
            return new SWResult(false, name + " must not null");
        } else if(value.toString().equals("")) {
            return new SWResult(false, name + " must not empty");
        } else {
            return new SWResult(true);
        }
    }

}
