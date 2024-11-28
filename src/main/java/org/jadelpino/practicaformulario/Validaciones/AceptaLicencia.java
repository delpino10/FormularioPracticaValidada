package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = AceptaLicencia_Validator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface AceptaLicencia {
    String message() default "{Validacion.Licencia.true}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
