package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = FechaNacMasDe18anios_Validator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaNacMasDe18anios {
    String message() default "{Validacion.fechaNac.EdadMinima}";
    int value() default 18; // Edad mínima por defecto
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
