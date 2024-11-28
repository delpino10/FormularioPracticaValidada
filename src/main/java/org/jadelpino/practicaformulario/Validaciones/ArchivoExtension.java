package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;


@Constraint(validatedBy = ArchivoExtension_Validator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface ArchivoExtension {
    String message() default "{Validacion.archivoExtension.pattern}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
