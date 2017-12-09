package com.lunchmaster.api.registration.validation.validator;

import com.lunchmaster.api.registration.service.RegistrationService;
import com.lunchmaster.api.registration.validation.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator
implements ConstraintValidator<UniqueEmail, String>{

    private RegistrationService registrationService;

    public UniqueEmailValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(email == null || email.trim().equals("")) {
            return true;
        }

        return registrationService.isEmailUnique(email);
    }
}
