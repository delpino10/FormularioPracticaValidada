package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AceptaLicencia_Validator implements ConstraintValidator<AceptaLicencia, Boolean> {
    @Override
    public boolean isValid(Boolean valor, ConstraintValidatorContext constraintValidatorContext) {
        // El valor debe ser 'true', que indica que el checkbox está marcado
        return !Boolean.FALSE.equals(valor);


    }
}
