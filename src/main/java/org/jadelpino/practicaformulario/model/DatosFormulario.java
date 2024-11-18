package org.jadelpino.practicaformulario.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class DatosFormulario {

    private String usuario;
    private String clave;
    private String confirmarClave;
    private String generoSeleccionado;
    private String paisSeleccionado;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private float peso;
    private String prefijoTelefonico;
    private String telefono;
    private String email;
    private String url;
    private String archivos;
    private List<String> musicasSeleccionadas;
    private List<String> aficionesSeleccionadas;
    private String comentarios;
    private boolean licencia;

}
