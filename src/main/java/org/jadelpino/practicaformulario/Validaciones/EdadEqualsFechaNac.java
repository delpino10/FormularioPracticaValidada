package org.jadelpino.practicaformulario.Validaciones;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = EdadEqualsFechaNac_Validator.class)
@Target({TYPE_USE, TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EdadEqualsFechaNac {
    String message() default "{Validacion.edad.EdadEqualsFechaNac}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
