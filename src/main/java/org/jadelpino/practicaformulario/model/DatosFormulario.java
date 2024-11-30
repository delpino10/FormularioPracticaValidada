package org.jadelpino.practicaformulario.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.jadelpino.practicaformulario.Validaciones.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
// Valida si los años transcurridos concuerdan con la edad
@EdadEqualsFechaNac
// Valida que las contraseñas sean iguales
@ContraseniasCoincidente
public class DatosFormulario {
    @NotBlank
    private String usuario = "Lola";// String Lola como valor por defecto a la vista

    @NotBlank
            //(message = "{Validacion.clave.notBlank}")
    @Size(min = 6, max = 12, message= "{Validacion.clave.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&])[A-Za-z\\d!#$%&]{1,}$",
            message = "{Validacion.clave.CaracterEspecial}"
    )
    private String clave;

    @NotBlank//(message = "{Validacion.confirmarClave.notBlank}")
    @Size(min = 6, max = 12, message= "{Validacion.confirmarClave.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&])[A-Za-z\\d!#$%&]{1,}$",
            message = "{Validacion.confirmarClave.CaracterEspecial}"
    )
    private String confirmarClave;

    //@NotEmpty(message = "{Validacion.generoSeleccionado.notBlank}")

    @Pattern(
            regexp = "^(M|F|O)$",
            message = "{Validacion.generoSeleccionado.notBlank}"
    )
    @NotNull
    private String generoSeleccionado;


    @Pattern(
            regexp = "^(pt|es|fr|uk|it)$",
            message = "{paisSeleccionado.notBlank}"
    )
    private String paisSeleccionado = "pt";

    @NotNull
    //Valida una fecha es de hace más de 18 años
    @FechaNacMasDe18anios
    // Valida que la fecha insertada sea anterior a hoy
    @Past(message = "{Validacion.fechaNac.Past}")
    // Valida que el formato sea dd/MM/yyyy
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaNacimiento;

    @NotNull
    private Integer edad;

    @Digits(integer = 3, fraction = 2, message = "{Validacion.peso.Digits}")
    @NotNull
    private Float peso;

    @NotBlank
    @NotNull
    @Pattern(
            regexp = "^(pt|es|fr|uk|it)$",
            message = "El valor debe ser uno de los siguientes: pt, es, fr, uk o it")
    private String prefijoTelefonico = "fr";

    @NotNull
    @NotBlank
    @Size(min = 9, message = "{Vaidacion.telefono.Size}")
    private String telefono;

    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "{Vaidacion.email.pattern}"
    )
    @NotNull
    private String email;

    //@Url
    @Pattern(regexp = "^www\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$",
    message = "{Vaidacion.url.pattern}")
    @NotNull
    private String url;

    @NotNull
    @Pattern(
            regexp = "^.+\\.(?i)(pdf|jpg|jpeg|gif)$",
            message = "{Validacion.archivoExtension.pattern}"
    )
    private String archivos;

    @Size(min=1, message = "{Validacion.unTipoMusica.contains}")
    private List<String> musicasSeleccionadas = musicasDefecto();


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

