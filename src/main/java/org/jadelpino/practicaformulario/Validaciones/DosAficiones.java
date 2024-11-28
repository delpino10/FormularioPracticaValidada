package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = DosAficiones_Validator.class)
@Target({ElementType.TYPE, FIELD})
@Retention(RUNTIME)
public @interface DosAficiones {
    String message() default "{Validacion.dosTiposAficiones.contains}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
