package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public @interface FormatoValido {

    @Target({ FIELD, PARAMETER })
    @Retention(RUNTIME)
    @Constraint(validatedBy = FormatoValidoValidator.class)
    @Documented
    public @interface FechaValida {

        String message() default "{Validacion.fechaNac.formato}";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

    }

}
