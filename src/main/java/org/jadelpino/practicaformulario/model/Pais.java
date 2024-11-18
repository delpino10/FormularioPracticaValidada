package org.jadelpino.practicaformulario.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Pais {
    private String pais;
    private String Idioma;
    private String prefijoTelefonicoPais;
    private boolean muestraIdioma;
    private String nombreArchivoBandera;
}
