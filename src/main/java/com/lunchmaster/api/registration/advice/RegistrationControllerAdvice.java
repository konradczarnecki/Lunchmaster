package com.lunchmaster.api.registration.advice;

import com.lunchmaster.api.registration.exception.EmailAlreadyTakenException;
import com.lunchmaster.utils.dto.ValidationErrorResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistrationControllerAdvice {

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<ValidationErrorResponseBody> emailTakenHandler(EmailAlreadyTakenException exc) {
        ValidationErrorResponseBody responseBody = new ValidationErrorResponseBody();
        responseBody.getErrorMessages().put("email", exc.getMessage());

        return ResponseEntity.badRequest().body(responseBody);
    }
}
