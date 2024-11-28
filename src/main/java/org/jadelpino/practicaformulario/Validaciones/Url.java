package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = Url_Validator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface Url {
    String message() default "{Vaidacion.url.pattern}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
