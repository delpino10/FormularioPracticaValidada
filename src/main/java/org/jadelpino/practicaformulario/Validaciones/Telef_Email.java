package org.jadelpino.practicaformulario.Validaciones;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// La anotación personalizada
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Telef_Email_lValidator.class)
public @interface Telef_Email {
    String message() default "Debe ingresar al menos un número de teléfono o una dirección de correo electrónico.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
