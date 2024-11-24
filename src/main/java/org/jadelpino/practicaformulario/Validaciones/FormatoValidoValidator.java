package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class FormatoValidoValidator implements ConstraintValidator<FormatoValido, String> {

    private static final String DATE_PATTERN = "dd/MM/yyyy";


    @Override
    public void initialize(FormatoValido constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        try
        {
            sdf.setLenient(false);
            Date d = sdf.parse(s);
            return true;
        }
        catch (ParseException e)
        {
            return false;
        }
    }



}
