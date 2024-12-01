package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Edad_Validator implements ConstraintValidator<ValidarEdad, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        // Permitir que el valor sea nulo (interpretado como vacío en el formulario)
        if (value == null) {
            return true; // Los valores vacíos son válidos
        }

        // Validar que sea un número entero positivo o cero
        return value >= 0;
    }


}
