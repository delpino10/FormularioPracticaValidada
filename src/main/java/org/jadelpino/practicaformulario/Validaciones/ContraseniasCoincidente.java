package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

    @Constraint(validatedBy =ContraseniasCoincidente_Validator.class)
    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ContraseniasCoincidente {
        String message() default "{Validacion.confirmarClave.ContraseniasCoincidente}";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

