package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ComentarioVacio_Validator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface ComentarioVacio {
    String message() default "{Validacion.comentario.cadenaVacia}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
