package org.jadelpino.practicaformulario.controller;

import org.jadelpino.practicaformulario.model.Colecciones;
import org.jadelpino.practicaformulario.model.DatosFormulario;
import org.jadelpino.practicaformulario.model.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

// Controlador Principal
@Controller
@RequestMapping("formulario")
public class PrincipalController {
    // Iniciamos el contador de las interacciones
    int interaccion = 1;



    @ModelAttribute("lista_paises")
    private Map<String, Pais> devuelveListaPaices() {
        return Colecciones.getListaPaises();
    }

    @ModelAttribute("lista_generos")
    private Map<String, String> devuelveListaGeneros() {
        return Colecciones.getListaGeneros();
    }

    @ModelAttribute("lista_musicas")
    private Map<String, String> devuelveListaMusicas() {
        return Colecciones.getListaMusicas();
    }

    @ModelAttribute("lista_aficiones")
    private Map<String, String> devuelveListaAficiones() {
        return Colecciones.getListaAficiones();
    }


    // Envía la plantilla del formulario a rellenar por el usuario
    @GetMapping("devuelve-formulario")
    public String devuelveFormulario(
            @ModelAttribute ("datosFormulario") DatosFormulario datosFormulario,
            Model modelo) {
        // Titulo
        String titulo = " Original";
        // Campo Usuario
        String usuario = "Lola";
        // Campo Paises
        String pais_seleccionado ="pt";
        // Campo Aficiones
        ArrayList<String> aficionesDefecto = new ArrayList<>();
        aficionesDefecto.add("D");
        aficionesDefecto.add("P");
        aficionesDefecto.add("V");
        // Campo Músicas
        ArrayList<String> musicasDefecto = new ArrayList<>();
        musicasDefecto.add("F");
        musicasDefecto.add("P");


        // Titulo
        modelo.addAttribute("titulo", titulo);
        // Campo Aficiones
        modelo.addAttribute("aficionesDefecto", aficionesDefecto);
        // Campo Paises
        modelo.addAttribute("pais_seleccionado", pais_seleccionado );
        // CAmpo Música
        modelo.addAttribute("musicasDefecto", musicasDefecto);
        // Campo Usuario
        modelo.addAttribute("usuario", usuario);
        // Campo Licencia
        modelo.addAttribute("licencia", false);
        // Interacciones
       // modelo.addAttribute("interaccion", interaccion);

        return "formulario";
    }

    // Desactiva la peticion del favicon.ico
    @Controller
    static class FaviconController {

        @GetMapping("favicon.ico")
        @ResponseBody
        void returnNoFavicon() {
        }
    }

    // Recibe los parámetros del formulario y los pasa de nuevo a la vista
    @PostMapping("recibeParametrosYRepinta")
    public String recibeParametros(
            DatosFormulario datosFormulario,
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) String confirmarClave,
            @RequestParam(required = false) String genero_seleccionado,
            @RequestParam(required = false) String pais_seleccionado,
            @RequestParam(required = false) LocalDate FechaNacimiento,
            @RequestParam(required = false) Integer edad,
            @RequestParam(required = false) Float peso,
            @RequestParam(required = false) String prefijoTelefonico,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String url,
            @RequestParam(value = "archivoSubido", required = false) String archivo,
            @RequestParam(required = false) ArrayList<String> musicas_seleccionadas,
            @RequestParam(required = false) ArrayList<String> aficiones_seleccionadas,
            @RequestParam(required = false) String comentario,
            @RequestParam(required = false) Boolean licencia,
            // accedemos al objeto que muestran las coordenadas en x
            @RequestParam(name = "imagen.x", required = false) Integer x,
            // accedemos al objeto que muestran las coordenadas en y
            @RequestParam(name = "imagen.y", required = false) Integer y,
            Model modelo) {

        //Título
        String titulo = " Repintado";

        usuario = datosFormulario.getUsuario();
        clave = datosFormulario.getClave();
        confirmarClave = datosFormulario.getConfirmarClave();
        pais_seleccionado = datosFormulario.getPaisSeleccionado();
        prefijoTelefonico = datosFormulario.getPrefijoTelefonico();

        System.err.println(datosFormulario.toString());



        modelo.addAttribute("titulo", titulo);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("confirmarClave", confirmarClave);
        modelo.addAttribute("genero_seleccionado", genero_seleccionado);
        modelo.addAttribute("pais_seleccionado", pais_seleccionado);
        modelo.addAttribute("FechaNacimiento", FechaNacimiento);
        modelo.addAttribute("edad", edad);
        modelo.addAttribute("peso", peso);
        modelo.addAttribute("prefijoTelefonico", prefijoTelefonico);
        modelo.addAttribute("telefono", telefono);
        modelo.addAttribute("email", email);
        modelo.addAttribute("url", url);
        modelo.addAttribute("archivo", archivo);
        modelo.addAttribute("aficionArray", aficiones_seleccionadas);
        modelo.addAttribute("musicaArray", musicas_seleccionadas);
        modelo.addAttribute("licencia", licencia);
        modelo.addAttribute("comentario", comentario);
        modelo.addAttribute("archivo", archivo);

//        modelo.addAttribute("interaccion", interacciones);

        // Mostrar el mensaje de las coordenadas en la vista
        String coordenadas = coordenadasImage(x,y);
        modelo.addAttribute("coordenadas", coordenadas);


        return "formulario";
    }

    @PostMapping("rec-prueba")
    public String recPrueba(DatosFormulario datosFormulario, Model modelo) {

        System.err.println(datosFormulario.toString());

        return "formulario";
    }

        // Mostrar el mensaje de las coordenadas en la vista
    public static String coordenadasImage (Integer x , Integer y){
        String coordenadas = (x != null && y != null)
                ? "imagen.x: " + x + " e imagen.y: " + x
                : "";
        return coordenadas;
    }

}
