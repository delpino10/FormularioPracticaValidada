package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class FechaNacMasDe18anios_Validator implements ConstraintValidator <FechaNacMasDe18anios, LocalDate>{
    private int minimaEdad;

    @Override
    public void initialize(FechaNacMasDe18anios constraintAnnotation) {
        this.minimaEdad = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }

        LocalDate today = LocalDate.now();
        int edad = Period.between(date, today).getYears();
        return edad >= minimaEdad;
    }
}
