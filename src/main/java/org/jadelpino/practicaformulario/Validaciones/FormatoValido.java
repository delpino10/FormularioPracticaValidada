package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public @interface FormatoValido {

    @Target({ ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = FormatoValidoValidator.class)
    @Documented
    public @interface FechaValida {

        String message() default "{Validacion.fechaNac.formato}";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

    }

}
