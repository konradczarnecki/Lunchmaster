package com.lunchmaster.api.registration.validation;

import com.lunchmaster.api.registration.validation.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {

    String message() default "Email is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
