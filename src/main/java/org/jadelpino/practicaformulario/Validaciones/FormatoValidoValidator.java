package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FormatoValidoValidator implements ConstraintValidator<FormatoValido, String> {

    private static final String DATE_PATTERN = "dd/MM/yyyy";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;  // Si la fecha está vacía, se puede tratar como válida o manejarse de forma especial.
        }

        // Usamos SimpleDateFormat para validar que la fecha esté en el formato correcto
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        dateFormat.setLenient(false);  // Hace que la fecha no sea tolerante con valores incorrectos (como el 31 de febrero)

        try {
            dateFormat.parse(value);  // Si se puede analizar la fecha, es válida
            return true;
        } catch (ParseException e) {
            // Si ocurre un error al analizar la fecha, la validación falla
            System.err.println(e.getMessage());
            return false;
        }
    }
}
