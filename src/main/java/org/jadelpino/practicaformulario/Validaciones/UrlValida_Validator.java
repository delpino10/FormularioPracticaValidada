package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UrlValida_Validator implements ConstraintValidator <urlValida, String> {

    private static final String URL = "^(|www\\.[a-zA-Z0-9-]+\\.[a-z]{2,})$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty()) {
            return true; // Permitir valores vacíos o nulos
        }
        return value.matches(URL);
    }
}
