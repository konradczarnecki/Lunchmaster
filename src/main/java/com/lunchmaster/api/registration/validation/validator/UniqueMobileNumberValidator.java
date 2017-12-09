package com.lunchmaster.api.registration.validation.validator;

import com.lunchmaster.api.registration.service.RegistrationService;
import com.lunchmaster.api.registration.validation.UniqueMobileNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueMobileNumberValidator
implements ConstraintValidator<UniqueMobileNumber, String>{

    private RegistrationService registrationService;

    public UniqueMobileNumberValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void initialize(UniqueMobileNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext context) {

        if(mobile == null || mobile.trim().equals("")) {
            return true;
        }

        return registrationService.isMobileUnique(mobile);
    }
}
