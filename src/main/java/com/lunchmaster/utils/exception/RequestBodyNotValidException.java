package com.lunchmaster.utils.exception;

import org.springframework.validation.ObjectError;

import java.util.List;

public class RequestBodyNotValidException extends RuntimeException {

    private List<ObjectError> errors;

    public RequestBodyNotValidException(List<ObjectError> errors) {
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }
}
