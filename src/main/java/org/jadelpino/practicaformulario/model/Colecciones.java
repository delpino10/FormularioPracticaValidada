package org.jadelpino.practicaformulario.model;

import java.util.Map;
import java.util.TreeMap;

public class Colecciones {
    private static final Map<String, String> listaGenero = new TreeMap<>();

    private static final Map<String, String> listaAficiones = new TreeMap<>();

    private static final Map<String, String> listaPaises = new TreeMap<>();

    private static final Map<String, String> listaMusica = new TreeMap<>();

    static{
        listaGenero.put("M", "Masculino");
        listaGenero.put("F", "Femenino");
        listaGenero.put("O", "Otro");

        listaAficiones.put("D", "Deporte");
        listaAficiones.put("L", "Lectura");
        listaAficiones.put("P", "Pintura");
        listaAficiones.put("V", "Viajes");

        listaPaises.put("A", "Andorra");
        listaPaises.put("E", "España");
        listaPaises.put("F", "Francia");
        listaPaises.put("P", "Portugal");

        listaMusica.put("E", "Electrónica");
        listaMusica.put("F", "Funky");
        listaMusica.put("N", "New Age");
        listaMusica.put("P", "Pop");
        listaMusica.put("R", "Rock");
    }


    public static Map<String, String> getListaGenero() {
        return listaGenero;
    }

    public static Map<String, String> getListaAficiones() {
        return listaAficiones;
    }

    public static Map<String, String> getListaPaises() {
        return listaPaises;
    }

    public static Map<String, String> getListaMusica() {
        return listaMusica;
    }
}
