package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface ContraseniasCoincidente {

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy =ContraseniasCoincidente_Validator.class)
    public @interface PasswordMatch {
        String message() default "{Validacion.confirmarClave.ContraseñasCoincidente}";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
