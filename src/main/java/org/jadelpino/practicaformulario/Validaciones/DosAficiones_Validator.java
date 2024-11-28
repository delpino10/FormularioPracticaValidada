package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class DosAficiones_Validator implements ConstraintValidator <DosAficiones, List<String>>{
    @Override
    public boolean isValid(List<String> tiposMusicas, ConstraintValidatorContext constraintValidatorContext) {
        if (tiposMusicas == null || tiposMusicas.isEmpty()) {
            return false; // Si la lista está vacía, no es válida
        }

        return tiposMusicas.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .count() >= 2;
    }
}
