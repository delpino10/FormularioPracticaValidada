package org.jadelpino.practicaformulario.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class DatosFormulario {
    @NotBlank(message = "Por favor, rellene el campo usuario")
    private String usuario = "Lola"; // String Lola como valor por defecto a la vista
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    //Portugal como pais por defecto a la vista
    private String paisSeleccionado = "pt";
    private LocalDate fechaNacimiento;
    private Integer edad;
    private Float peso;
    // Prefijo Francia como Prefijo por defecto a la vista
    private String prefijoTelefonico = "fr";
    private String telefono;
    private String email;
    private String url;
    private String archivos;
    // Pasamos los valores de las musicas por defecto a la vista
    private List<String> musicasSeleccionadas = musicasDefecto();
    // Pasamos los valores de las aficiones por defecto a la vista
    private List<String> aficionesSeleccionadas = aficionesDefecto();
    private String comentarios;
    private Boolean licencia;

    // Guardamos en un Arraylist los valores por defecto de aficiones
    private List<String> aficionesDefecto(){
        List<String> aficionesDefecto = new ArrayList<String>();
        aficionesDefecto.add("D");
        aficionesDefecto.add("P");
        aficionesDefecto.add("V");
        return aficionesDefecto;

    }// Guardamos en un Arraylist los valores por defecto de musica
    private List<String> musicasDefecto(){
        List<String> musicasDefecto = new ArrayList<String>();
        musicasDefecto.add("F");
        musicasDefecto.add("P");
        return musicasDefecto;
    }

}
