package org.jadelpino.practicaformulario.Validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArchivoExtension_Validator implements ConstraintValidator<ArchivoExtension, String> {

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList("pdf", "jpg", "jpeg", "gif");

    @Override
    public boolean isValid(String archivo, ConstraintValidatorContext constraintValidatorContext) {
        if (archivo == null || archivo.isBlank()) {
            return true; // Válido si el nombre del archivo está vacío
        }

        // Extraer la extensión
        int dotIndex = archivo.lastIndexOf('.');
        if (dotIndex == -1) {
            return false; // No tiene extensión
        }

        String extensionArchivo = archivo.substring(dotIndex + 1).toLowerCase();

        // Validar usando un Stream
        return Stream.of("pdf", "jpg", "jpeg", "gif")
                .anyMatch(extensionArchivo::equals);
    }
}
