package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface urlValida {

@Constraint(validatedBy = UrlValida_Validator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UrlValida {
    String message() default "La URL debe seguir el formato www.unaweb.com o estar vacía.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

}
