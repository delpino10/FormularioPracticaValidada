package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ComentarioVacio_Validator implements ConstraintValidator<ComentarioVacio, String> {
    @Override
    public boolean isValid(String comentario, ConstraintValidatorContext constraintValidatorContext) {
        return comentario != null;
    }
}
