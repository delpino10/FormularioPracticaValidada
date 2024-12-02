package org.jadelpino.practicaformulario.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
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

    @NotNull
    @Pattern(
            regexp = "^(M|F|O)$",
            message = "{Validacion.generoSeleccionado.notBlank}"
    )
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
    @Min(18)
    @Max(67)
    private Integer edad;

    @NotNull
    @Digits(integer = 3, fraction = 2, message = "{Validacion.peso.Digits}")
    private Float peso;


    @NotNull
    @Pattern(
            regexp = "^(pt|es|fr|uk|it)$",
            message = "{Validacion.prefijoSeleccionado.notBlank}")
    private String prefijoTelefonico = "fr";

    @NotNull
    @Size(min = 9, message = "{Vaidacion.telefono.Size}")
    private String telefono;

    @NotNull
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

