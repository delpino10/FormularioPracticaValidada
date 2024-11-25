package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.jadelpino.practicaformulario.model.DatosFormulario;

import java.time.LocalDate;
import java.time.Period;

public class EdadEqualsFechaNac_Validator implements ConstraintValidator<EdadEqualsFechaNac, DatosFormulario> {



    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext constraintValidatorContext) {

        LocalDate fechaNacimiento = datosFormulario.getFechaNacimiento();
        Integer edad = datosFormulario.getEdad();

        // Validar que ambos campos no sean nulos
        if (fechaNacimiento == null || edad == null) {
            return true; // Deja que otras validaciones, como @NotNull, manejen esto
        }

        // Calcular los años transcurridos entre la edad y la fecha de NAcimiento
        Integer edadCalculada = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        System.out.printf("Edad calculada: %d, Edad ingresada: %d%n", edadCalculada, edad);

        return edad.equals(edadCalculada);
    }
}
