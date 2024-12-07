package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.jadelpino.practicaformulario.model.DatosFormulario;

public class Telef_Email_lValidator implements ConstraintValidator <Telef_Email, DatosFormulario>{
    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext constraintValidatorContext) {
        // Verificar que al menos uno de los campos teléfono o email esté presente
        boolean telefonoValido = datosFormulario.getTelefono() != null && !datosFormulario.getTelefono().isEmpty();
        boolean emailValido = datosFormulario.getEmail() != null && !datosFormulario.getEmail().isEmpty();

        return telefonoValido || emailValido;  // Si alguno de los dos campos no está vacío, es válido
    }
}
