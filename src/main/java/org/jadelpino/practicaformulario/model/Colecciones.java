package org.jadelpino.practicaformulario.model;

import java.util.Map;
import java.util.TreeMap;

public class Colecciones {
    private static final Map<String, String> listaGeneros = new TreeMap<>();

    private static final Map<String, String> listaAficiones = new TreeMap<>();

    private static final Map<String, Pais> listaPaises = new TreeMap<>();

    private static final Map<String, String> listaMusicas = new TreeMap<>();


    static{
        listaGeneros.put("M", "Masculino");
        listaGeneros.put("F", "Femenino");
        listaGeneros.put("O", "Otro");

        listaAficiones.put("D", "Deporte");
        listaAficiones.put("L", "Lectura");
        listaAficiones.put("P", "Pintura");
        listaAficiones.put("V", "Viajes");

        listaPaises.put("es", new Pais("España", "Castellano", "+34", true, "espania.jpg"));
        listaPaises.put("fr", new Pais("Francia", "Francés", "+33", false, "francia.jpg"));
        listaPaises.put("it", new Pais("Italia", "Italiano", "+39", false, "italia.jpg"));
        listaPaises.put("pt", new Pais("Portugal", "Portugués", "+351", false, "portugal.jpg"));
        listaPaises.put("en", new Pais("Reino Unido", "Ingl", "+44", true, "reino_unido.jpg"));

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

    public static Map<String, Pais> getListaPaises() {
        return listaPaises;
    }

    public static Map<String, String> getListaMusicas() {
        return listaMusicas;
    }
}
