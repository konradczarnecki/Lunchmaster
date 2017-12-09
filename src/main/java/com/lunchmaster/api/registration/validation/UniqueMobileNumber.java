package com.lunchmaster.api.registration.validation;

import com.lunchmaster.api.registration.validation.validator.UniqueMobileNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueMobileNumberValidator.class)
@Documented
public @interface UniqueMobileNumber {

    String message() default "Mobile number is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
