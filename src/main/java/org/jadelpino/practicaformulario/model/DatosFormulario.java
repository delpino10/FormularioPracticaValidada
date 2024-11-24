package org.jadelpino.practicaformulario.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.jadelpino.practicaformulario.Validaciones.FormatoValido;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString

public class DatosFormulario {
    @NotNull(message = "No puede ser nulo")
    @NotBlank(message = "{Validacion.usuario.notBlank}")
    private String usuario = "Lola";// String Lola como valor por defecto a la vista

    @NotBlank(message = "{Validacion.clave.notBlank}")
    @Size(min = 6, max = 12, message= "{Validacion.clave.size}")
    private String clave;

    @NotBlank(message = "{Validacion.confirmarClave.notBlank}")
    private String confirmarClave;

    @NotEmpty(message = "{Validacion.generoSeleccionado.notBlank}")
    private String generoSeleccionado;

    private String paisSeleccionado = "pt";

    //@NotBlank(message = "{Validacion.fechaNAc.notBlank}")
    @Past(message = "{Validacion.fechaNAc.Past}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @FormatoValido
    private LocalDate fechaNacimiento;

    @NotNull
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

