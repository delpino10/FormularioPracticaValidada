package org.jadelpino.practicaformulario.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pais {
    private final String pais;
    private final String Idioma;
    private final String prefijoTelefonicoPais;
    private final boolean muestraIdioma;
    private final String nombreArchivoBandera;
}
