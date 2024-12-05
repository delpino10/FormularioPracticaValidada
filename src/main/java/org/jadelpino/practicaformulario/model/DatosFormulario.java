package org.jadelpino.practicaformulario.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.jadelpino.practicaformulario.Validaciones.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Data
// Válida si los años transcurridos concuerdan desde la fecha de nacimiento
@EdadEqualsFechaNac
// Válida que las contraseñas sean iguales
@ContraseniasCoincidente
public class DatosFormulario {
    @NotBlank
    private String nombre = "Lola";// String Lola como valor por defecto a la vista

    @NotBlank
    @Size(min = 6, max = 12, message= "{Validacion.clave.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&])[A-Za-z\\d!#$%&]{1,}$",
            message = "{Validacion.clave.CaracterEspecial}"
    )
    private String clave;
    // Válida que las contraseñas sean iguales

    @NotBlank
    @Size(min = 6, max = 12, message= "{Validacion.confirmarClave.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&])[A-Za-z\\d!#$%&]{1,}$",
            message = "{Validacion.confirmarClave.CaracterEspecial}"
    )
    private String confirmarClave;

    @NotNull
    @Pattern(
            regexp = "^([MFO])$",
            message = "{Validacion.generoSeleccionado.notBlank}"
    )
    private String generoSeleccionado;

    @NotNull(message = "Este campo no puede quedar vacío")
    @Pattern(
            regexp = "^(pt|es|fr|uk|it)$",
            message = "{paisSeleccionado.notBlank}"
    )
    private String paisSeleccionado = "pt";

    @NotNull
    // Válida una fecha es de hace más de 18 años
    @FechaNacMasDe18anios
    // Válida que la fecha insertada sea anterior a hoy
    @Past(message = "{Validacion.fechaNac.Past}")
    // Válida que el formato sea dd/MM/yyyy
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;


    @Min(18)
    private Integer edad;

    @NotNull
    @Digits(integer = 3, fraction = 2, message = "{Validacion.peso.Digits}")
    private Float peso;


    @NotNull
    @Pattern(
            regexp = "^(pt|es|fr|uk|it)$",
            message = "{Validacion.prefijoSeleccionado.notBlank}")
    private String prefijoTelefonico = "fr";


    @Size(min = 9, message = "{Vaidacion.telefono.Size}")
    @Pattern(regexp = "^[0-9]+$",
    message = "{Validacion.telefono.digitos}")
    private String telefono;


    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "{Vaidacion.email.pattern}"
    )
    private String email;


    @NotNull
    @Pattern(regexp = "^www\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$",
    message = "{Vaidacion.url.pattern}")
    private String url;

    @NotNull
    @Pattern(
            regexp = "^.+\\.(?i)(pdf|jpg|jpeg|gif)$",
            message = "{Validacion.archivoExtension.pattern}"
    )
    private String archivos;

    @NotNull
    @Size(min=1, message = "{Validacion.unTipoMusica.contains}")
    private List<String> musicasSeleccionadas = musicasDefecto();

    @NotNull
    @Size(min=2,
        message = "{Validacion.dosTiposAficiones.contains}")
    private List<String> aficionesSeleccionadas = aficionesDefecto();

    @NotNull
    private String comentarios;

    @NotNull
    @AssertTrue(message = "{Validacion.Licencia.true}")
    private Boolean licencia;

    // List con valores por defecto de Aficiones
    private List<String> aficionesDefecto(){
        aficionesSeleccionadas = new ArrayList<>();
        aficionesSeleccionadas.add("D");
        aficionesSeleccionadas.add("P");
        aficionesSeleccionadas.add("V");
        return aficionesSeleccionadas;
    }
    // List con valores por defecto de tipos de Musica
    private List<String> musicasDefecto(){
        musicasSeleccionadas = new ArrayList<>();
        musicasSeleccionadas.add("F");
        musicasSeleccionadas.add("P");
        return musicasSeleccionadas;
    }


}

