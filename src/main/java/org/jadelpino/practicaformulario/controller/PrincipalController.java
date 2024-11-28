package org.jadelpino.practicaformulario.controller;

import jakarta.validation.Valid;
import org.jadelpino.practicaformulario.model.Colecciones;
import org.jadelpino.practicaformulario.model.DatosFormulario;
import org.jadelpino.practicaformulario.model.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
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
            Model modelo,
            @ModelAttribute ("datosFormulario") DatosFormulario datosFormulario) {
        // Titulo
        modelo.addAttribute("titulo", "Original");
        // Licencia por defecto desactivada
        modelo.addAttribute("licencia", false);
        // Interacciones
        modelo.addAttribute("interaccion", interaccion);

        return "formulario";
    }


    // Recibe los parámetros del formulario y los pasa de nuevo a la vista
    @PostMapping("recibeParametrosYRepinta")
    public String recibeParametros(

            // @ModelAttribute sirve para pasar datos al modelo de la vista.
            // Si se quita @ModelAttribute, habría que pasarlo con model.addAttribute
            // modelo.addAttribute("datos-formulario", datosFormulario);
            @Valid @ModelAttribute DatosFormulario datosFormulario,
            BindingResult bindingResult,
            // accedemos al nombre del archivo subido
            @RequestParam(value = "archivos", required = false) String archivo,
            // accedemos al objeto que muestran las coordenadas en x
            @RequestParam(name = "imagen.x", required = false) Integer x,
            // accedemos al objeto que muestran las coordenadas en y
            @RequestParam(name = "imagen.y", required = false) Integer y,
            Model modelo) {


        // Método que gestiona los errores globales relacionados con null
        // de los campos
        erroresGlobales(datosFormulario, bindingResult);

        // Si hay errores
        if(bindingResult.hasErrors()) {
            String mensajeNOK = "ALERTA: Formulario con errores";
            modelo.addAttribute("mensajeNOK", mensajeNOK);

            // Interacciones
            interaccion++;
            modelo.addAttribute("interaccion", interaccion);

            //Título
            modelo.addAttribute("titulo", " Repintado");

            // Mostrar el mensaje de las coordenadas en la vista
            String coordenadas = coordenadasImage(x,y);
            modelo.addAttribute("coordenadas", coordenadas);

            // Mostrar el nombre del archivo
            modelo.addAttribute("archivo", archivo);

            return "formulario";
        }

        // Muestra el mensaje cuando el formulario no contiene errores
        String mensajeOK = "ALELUYA: formualrio sin errores";
        modelo.addAttribute("mensajeOK", mensajeOK);

        // Interacciones
        interaccion++;
        modelo.addAttribute("interaccion", interaccion);

        //Título
        modelo.addAttribute("titulo", " Repintado");

        // Mostrar el mensaje de las coordenadas de la imagen en la vista
        String coordenadas = coordenadasImage(x,y);
        modelo.addAttribute("coordenadas", coordenadas);

        // Mostrar el nombre del archivo
        modelo.addAttribute("archivo", archivo);

        // Comprueba que los datos han llegado al servidor
        System.err.println(datosFormulario.toString());

        return "formulario";
    }


    // Mostrar el mensaje de las coordenadas en la vista
    public static String coordenadasImage (Integer x , Integer y) {
        String coordenadas = (x != null && y != null)
                ? "imagen.x: " + x + " e imagen.y: " + x
                : "";
        return coordenadas;
    }

    // Gestionar los null para mostrar el mensaje de error Global
    public static void erroresGlobales(DatosFormulario datosFormulario,
                                       BindingResult bindingResult) {
        if((datosFormulario.getUsuario() == null)
                || (datosFormulario.getClave() == null)
                || (datosFormulario.getConfirmarClave() == null)
                || (datosFormulario.getGeneroSeleccionado() == null)
                || datosFormulario.getGeneroSeleccionado().isEmpty()
                || (datosFormulario.getPaisSeleccionado() == null)
                || (datosFormulario.getFechaNacimiento() == null)
                || (datosFormulario.getEdad() == null)
                || (datosFormulario.getPeso() == null)
                || (datosFormulario.getPrefijoTelefonico() == null)
                || (datosFormulario.getTelefono() == null)
                || (datosFormulario.getUrl() == null)
                || (datosFormulario.getArchivos() == null)
                || (datosFormulario.getComentarios() == null)
                || (datosFormulario.getLicencia() == null)
        ) {
            bindingResult.reject("Validacion.error.global");
        }
    }




}
