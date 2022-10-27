package com.grade.project.domain.utils.validations;

import com.grade.project.domain.exceptions.BadDataException;

public class DataValidation {

    public static void validationRequired(String value, String message) {
        if(null == value || value.isEmpty()) {
            throw new BadDataException(message);
        }
    }

    public static void validationRequired(Object value, String message) {
        if(null == value) {
            throw new BadDataException(message);
        }
    }
}
