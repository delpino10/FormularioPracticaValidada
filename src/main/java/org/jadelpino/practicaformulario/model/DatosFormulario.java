package org.jadelpino.practicaformulario.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class DatosFormulario {

    // String Lola como valor por defecto a la vista
    private String usuario = "Lola";
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    private String paisSeleccionado = "pt";
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Float peso;
    private String prefijoTelefonico = "fr";
    private String telefono;
    private String email;
    private String url;
    private String archivos;
    private List<String> musicasSeleccionadas = musicasDefecto();
    private List<String> aficionesSeleccionadas = aficionesDefecto();
    private String comentarios;
    private Boolean licencia;

    private List<String> aficionesDefecto(){
        aficionesSeleccionadas = new ArrayList<>();
        aficionesSeleccionadas.add("D");
        aficionesSeleccionadas.add("P");
        aficionesSeleccionadas.add("V");
        return aficionesSeleccionadas;
    }

    private List<String> musicasDefecto(){
        musicasSeleccionadas = new ArrayList<>();
        musicasSeleccionadas.add("F");
        musicasSeleccionadas.add("P");
        return musicasSeleccionadas;
    }
}

