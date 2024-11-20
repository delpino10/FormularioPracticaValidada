package org.jadelpino.practicaformulario.controller;

import jakarta.validation.Valid;
import org.jadelpino.practicaformulario.model.Colecciones;
import org.jadelpino.practicaformulario.model.DatosFormulario;
import org.jadelpino.practicaformulario.model.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

        // Titulo
        modelo.addAttribute("titulo", titulo);
        // Interacciones
       modelo.addAttribute("interaccion", interaccion);

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
            @Valid DatosFormulario datosFormulario,
            BindingResult bindingResult,
            // accedemos al objeto que muestran las coordenadas en x
            @RequestParam(name = "imagen.x", required = false) Integer x,
            // accedemos al objeto que muestran las coordenadas en y
            @RequestParam(name = "imagen.y", required = false) Integer y,
            Model modelo
            ) {

        if(bindingResult.hasErrors()) {// Si hay errores
            modelo.addAttribute("mensajeNOK", "El formulario contiene errores");
            // Suma uno cada vez que pulsamos enviar
            interaccion++;
            modelo.addAttribute("interaccion", interaccion);
            // Pinta Repinatdo el título
            modelo.addAttribute("titulo", " Repintado");

            return "formulario";
        }
        // Si no hay errores
        modelo.addAttribute("mensajeOk", "El formulario no contiene errores");

        System.err.println(datosFormulario.toString());


        // Pinta Repinatdo el título
        modelo.addAttribute("titulo", " Repintado");

        // Suma uno cada vez que pulsamos enviar
        interaccion++;
        modelo.addAttribute("interaccion", interaccion);

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
