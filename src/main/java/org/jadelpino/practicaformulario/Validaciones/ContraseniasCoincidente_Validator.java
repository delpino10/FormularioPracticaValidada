package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.jadelpino.practicaformulario.model.DatosFormulario;

public class ContraseniasCoincidente_Validator implements ConstraintValidator <ContraseniasCoincidente, DatosFormulario> {
    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext constraintValidatorContext) {

        return ((DatosFormulario) datosFormulario).getClave().equals(((DatosFormulario) datosFormulario).getConfirmarClave());
    }
}
