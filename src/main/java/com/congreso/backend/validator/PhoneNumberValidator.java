package com.congreso.backend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Override
    public boolean isValid(String number, ConstraintValidatorContext context) {
        return number != null && number.matches("[0-9]+") && number.length() > 7 && number.length() < 14;
    }
}
