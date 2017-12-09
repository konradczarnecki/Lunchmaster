package com.lunchmaster.api.registration.validation.validator;

import com.lunchmaster.api.registration.service.RegistrationService;
import com.lunchmaster.api.registration.validation.UniqueBankAccount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueBankAccountValidator
implements ConstraintValidator<UniqueBankAccount, String>{

    private RegistrationService registrationService;

    public UniqueBankAccountValidator(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @Override
    public void initialize(UniqueBankAccount constraintAnnotation) {
    }

    @Override
    public boolean isValid(String bankAccount, ConstraintValidatorContext context) {

        if(bankAccount == null || bankAccount.trim().equals("")) {
            return true;
        }

        return registrationService.isBankAccountUnique(bankAccount);
    }
}
