package com.lunchmaster.utils.dto;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ValidationErrorResponseBody {

    private Map<String, String> errorMessages;

    public ValidationErrorResponseBody() {
        this.errorMessages = new LinkedHashMap<>();
    }

    public void addErrorMessages(List<ObjectError> errors) {

        for (ObjectError error : errors) {
            this.errorMessages.put(((FieldError)error).getField(), error.getDefaultMessage());
        }
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
