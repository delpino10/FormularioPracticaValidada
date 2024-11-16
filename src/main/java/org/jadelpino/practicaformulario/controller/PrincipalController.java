package org.jadelpino.practicaformulario.controller;

import org.jadelpino.practicaformulario.model.Colecciones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("formulario")
public class PrincipalController {
    // Iniciamos el contador de las interacciones
    int interaccion = 0;

    @ModelAttribute("lista_paises")
    private Map<String, String> devuelveListaPaices() {
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



    @GetMapping("devuelve-formulario")
    public String devuelveFormulario(Model modelo) {

        String titulo = " Original";
        String usuario = "Pepe";

        ArrayList<String> aficionesDefecto = new ArrayList<>();
        aficionesDefecto.add("D");
        aficionesDefecto.add("P");
        aficionesDefecto.add("V");
        modelo.addAttribute("aficionesDefecto", aficionesDefecto);
        modelo.addAttribute("pais_seleccionado", "F");

        modelo.addAttribute("titulo", titulo);
        modelo.addAttribute("usuario", usuario);


        return "formulario";
    }

    @GetMapping("recibe-parametros")
    public String recibeParametros(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) String genero_seleccionado,
            @RequestParam(required = false) ArrayList<String> aficiones_seleccionadas,
            @RequestParam(required = false) String pais_seleccionado,
            @RequestParam(required = false) ArrayList<String> musicas_seleccionadas,
            Model modelo) {

        // Incrementamos las veces que se ha enviado el formulario
        interaccion++;
        // Las imprimimos por consola
        System.err.printf("Veces que ha sido enviado el formulario = %d \n", interaccion);

        String titulo = " Repintado";


        modelo.addAttribute("titulo", titulo);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("genero_seleccionado", genero_seleccionado);
        modelo.addAttribute("aficionArray", aficiones_seleccionadas);
        modelo.addAttribute("pais_seleccionado", pais_seleccionado);
        modelo.addAttribute("musica_seleccionada", musicas_seleccionadas);
        modelo.addAttribute("interaccion", interaccion);

        return "formulario";
    }

}
