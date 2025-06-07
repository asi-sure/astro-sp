package com.congreso.backend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Constraint(validatedBy = EmailNameValidator.class)
public @interface ValidEmail {
    String message() default "Email invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
