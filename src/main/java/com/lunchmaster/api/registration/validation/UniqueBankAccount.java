package com.lunchmaster.api.registration.validation;

import com.lunchmaster.api.registration.validation.validator.UniqueBankAccountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueBankAccountValidator.class)
@Documented
public @interface UniqueBankAccount {

    String message() default "Bank account is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
