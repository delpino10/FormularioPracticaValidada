package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Url_Validator implements ConstraintValidator<Url,String> {
    private static final String URL_PATTERN = "^([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,})$";

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        if (url == null || url.isBlank()) {
            return true; // Válido si la url del archivo está vacío y es null
        }

        return url.matches(URL_PATTERN);
    }
}
