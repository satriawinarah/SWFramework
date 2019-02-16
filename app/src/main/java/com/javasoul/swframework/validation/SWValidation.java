package com.javasoul.swframework.validation;

import com.javasoul.swframework.constant.SWValidationType;
import com.javasoul.swframework.model.SWFieldColumn;
import com.javasoul.swframework.model.SWResult;
import com.javasoul.swframework.utils.SWUtils;

import java.util.ArrayList;
import java.util.List;

public class SWValidation {

    public static List<SWResult> validate(Object object) throws IllegalAccessException {
        List<SWResult> results = new ArrayList<>();
        List<SWFieldColumn> fields = SWUtils.getFieldsFromClass(object);

        for (SWFieldColumn field : fields) {
            SWResult result = checkNullAndEmpty(field.getColumnName(), field.getValue());
            if(result.getResult()) {
                results.add(validateWithValidationType(field));
            } else {
                results.add(result);
            }

        }
        return results;
    }

    private static SWResult validateWithValidationType(SWFieldColumn model) {
        String name = model.getColumnName();
        Object value = model.getValue();
        Object comparedValue = model.getComparedValue();
        List<String> validationTypes = model.getValidationTypes();

        for(String validationType: validationTypes) {
            if(validationType.equals(SWValidationType.COMPARE.toString())) {
                if(comparedValue == null) {
                    return new SWResult(false, name + " error comparing value: there is no value to compare");
                }

                if(!comparedValue.toString().equals(value.toString())) {
                    return new SWResult(false, name + " must equal to " + comparedValue.toString());
                }
            }

            if(value instanceof Integer || value instanceof Long) {
                if(validationType.equals(SWValidationType.NEGATIVE.toString())) {
                    if(Integer.parseInt(value.toString())<0) {
                        return new SWResult(false, name + " must not negative");
                    }
                }

                if(validationType.equals(SWValidationType.ZERO.toString())) {
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
