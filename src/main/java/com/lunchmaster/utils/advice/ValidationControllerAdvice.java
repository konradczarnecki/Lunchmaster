package com.lunchmaster.utils.advice;

import com.lunchmaster.utils.dto.ValidationErrorResponseBody;
import com.lunchmaster.utils.exception.RequestBodyNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationControllerAdvice {

    @ExceptionHandler(RequestBodyNotValidException.class)
    public ResponseEntity<ValidationErrorResponseBody> handleValidationError(RequestBodyNotValidException exception) {
        ValidationErrorResponseBody responseBody = new ValidationErrorResponseBody();
        responseBody.addErrorMessages(exception.getErrors());

        return ResponseEntity.badRequest().body(responseBody);
    }
}
