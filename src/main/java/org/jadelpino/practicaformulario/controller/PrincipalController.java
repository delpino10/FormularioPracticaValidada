package org.jadelpino.practicaformulario.controller;

import org.jadelpino.practicaformulario.model.Colecciones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("formulario")
public class PrincipalController {
    // Iniciamos el contador de las interacciones
    int interaccion = 0;

    @GetMapping("hola")
    @ResponseBody
    public String hola() {
        return "¡¡¡ Hola mundo !!!";
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

        modelo.addAttribute("titulo", titulo);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("lista_generos", Colecciones.getListaGenero());
        modelo.addAttribute("lista_aficiones", Colecciones.getListaAficiones());
        modelo.addAttribute("lista_paises", Colecciones.getListaPaises());
        modelo.addAttribute("lista_musica", Colecciones.getListaMusica());
        return "formulario";
    }

    @GetMapping("recibe-parametros")
    public String recibeParametros(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) String genero_seleccionado,
            @RequestParam(required = false) ArrayList<String> aficion_seleccionado,
            @RequestParam(required = false) String pais_seleccionado,
            Model modelo) {

        // Incrementamos las veces que se ha enviado el formulario
        interaccion++;
        // Las imprimimos por consola
        System.err.printf("Veces que ha sido enviado el formulario = %d \n", interaccion);

        String titulo = " Repintado";


        modelo.addAttribute("titulo", titulo);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("genero", genero_seleccionado);
        modelo.addAttribute("lista_generos", Colecciones.getListaGenero());
        modelo.addAttribute("aficion-seleccionada", aficion_seleccionado);
        modelo.addAttribute("lista_aficiones", Colecciones.getListaAficiones());
        modelo.addAttribute("pais-seleccionada", pais_seleccionado);
        modelo.addAttribute("lista_paises", Colecciones.getListaPaises());
        modelo.addAttribute("interaccion", interaccion);

        return "formulario";
    }

}
