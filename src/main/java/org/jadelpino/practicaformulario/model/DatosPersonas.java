package org.jadelpino.practicaformulario.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.*;
import static java.awt.AWTEventMulticaster.add;

@Getter @Setter
public class DatosPersonas {

    private static List<Persona> listaPersonas =
    // Sintaxis 1
   /* new ArrayList<Persona>(){{
                add(new Persona(1L,"Pepe", LocalDate.of(2000,1,2), 74.34F));
                add(new Persona(1L,"Pepe", LocalDate.of(2000,1,2), 74.34F));
    }};*/

    // Sintaxis 2 : Genera Objeto Inmutable
//    Arrays.asList(
//                new Persona(1L,"Pepe", LocalDate.of(2000,1,2), 74.34F),
//                new Persona(1L,"Pepe", LocalDate.of(2000,1,2), 74.34F)
//            );

    // Sintaxis 3

    Stream.of(
            new Persona(1L,"Pepe", LocalDate.of(2000,1,2), 74.34F),
            new Persona(1L,"Pepe", LocalDate.of(2000,1,2), 74.34F)
        )
    .toList();

    public static Persona getPersonaById(Long id) {
        return null;
    }


    public static List<Persona> getListaPersonas() {
        return listaPersonas;
    }
}
