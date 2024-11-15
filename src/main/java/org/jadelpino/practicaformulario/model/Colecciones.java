package org.jadelpino.practicaformulario.model;

import java.util.Map;
import java.util.TreeMap;

public class Colecciones {
    private static final Map<String, String> listaGeneros = new TreeMap<>();

    private static final Map<String, String> listaAficiones = new TreeMap<>();

    private static final Map<String, String> listaPaises = new TreeMap<>();

    private static final Map<String, String> listaMusicas = new TreeMap<>();

    static{
        listaGeneros.put("M", "Masculino");
        listaGeneros.put("F", "Femenino");
        listaGeneros.put("O", "Otro");

        listaAficiones.put("D", "Deporte");
        listaAficiones.put("L", "Lectura");
        listaAficiones.put("P", "Pintura");
        listaAficiones.put("V", "Viajes");

        listaPaises.put("A", "Andorra");
        listaPaises.put("E", "España");
        listaPaises.put("F", "Francia");
        listaPaises.put("P", "Portugal");

        listaMusicas.put("E", "Electrónica");
        listaMusicas.put("F", "Funky");
        listaMusicas.put("N", "New Age");
        listaMusicas.put("P", "Pop");
        listaMusicas.put("R", "Rock");
    }


    public static Map<String, String> getListaGeneros() {
        return listaGeneros;
    }

    public static Map<String, String> getListaAficiones() {
        return listaAficiones;
    }

    public static Map<String, String> getListaPaises() {
        return listaPaises;
    }

    public static Map<String, String> getListaMusicas() {
        return listaMusicas;
    }
}
