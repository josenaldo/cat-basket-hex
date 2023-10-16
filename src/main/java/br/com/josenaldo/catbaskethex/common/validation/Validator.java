package br.com.josenaldo.catbaskethex.common.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;

import java.util.Set;

public class Validator {
    private final static jakarta.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T subject) {
        Set<ConstraintViolation<T>> violations = validator.validate(subject);

        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
