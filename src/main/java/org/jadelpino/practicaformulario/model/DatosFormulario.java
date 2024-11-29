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

public class DatosFormulario {
    //@NotBlank(message = "{Validacion.usuario.notBlank}")
    @NotBlank
    private String usuario = "Lola";// String Lola como valor por defecto a la vista

    @NotBlank(message = "{Validacion.clave.notBlank}")
    @Size(min = 6, max = 12, message= "{Validacion.clave.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&])[A-Za-z\\d!#$%&]{1,}$",
            message = "{Validacion.clave.CaracterEspecial}"
    )
    private String clave;

    @NotBlank(message = "{Validacion.confirmarClave.notBlank}")
    @Size(min = 6, max = 12, message= "{Validacion.confirmarClave.size}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#$%&])[A-Za-z\\d!#$%&]{1,}$",
            message = "{Validacion.confirmarClave.CaracterEspecial}"
    )
    private String confirmarClave;

    @NotEmpty(message = "{Validacion.generoSeleccionado.notBlank}")
    // @Pattern
    private String generoSeleccionado;

    @NotBlank(message = "{Validacion.pais.NotBlank}")
    private String paisSeleccionado = "pt";

    @NotNull(message = "{Validacion.fechaNac.notNull}")
    // Valida que la fecha insertada sea anterior a hoy
    @Past(message = "{Validacion.fechaNac.Past}")
    // Valida que el formato sea dd/MM/yyyy
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    //Valida una fecha es de hace más de 18 años
    @FechaNacMasDe18anios
    private LocalDate fechaNacimiento;

    @NotNull
            //(message = "{Validacion.edad.notNull}")
    private Integer edad;

    @Digits(integer = 3, fraction = 2, message = "{Validacion.peso.Digits}")
    @NotNull(message = "{Validacion.peso.notNull}")
    private Float peso;

    //@Pattern que no sea fr..
    private String prefijoTelefonico = "fr";

    @NotNull
    @Size(min = 9,
    message = "{Vaidacion.telefono.Size}")
    private String telefono;

    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "{Vaidacion.email.pattern}"
    )
    private String email;

    @NotNull
    @Url
    //@Pattern
    private String url;

    @NotNull
    @ArchivoExtension
    private String archivos;
    @Size(min=1)
    @NotEmpty(message = "{Validacion.unTipoMusica.contains}")

    private List<String> musicasSeleccionadas = musicasDefecto();

    //@DosAficiones
    @Size(min=2)
    private List<String> aficionesSeleccionadas = aficionesDefecto();

    @NotNull
    //@ComentarioVacio
    private String comentarios;

    @NotNull
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

