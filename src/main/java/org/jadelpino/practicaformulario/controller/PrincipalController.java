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
    int interaccion = 1;

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
        // Titulo
        String titulo = " Original";
        // Campo Usuario
        String usuario = "Pepe";
        // Campo Aficiones
        ArrayList<String> aficionesDefecto = new ArrayList<>();
        aficionesDefecto.add("D");
        aficionesDefecto.add("P");
        aficionesDefecto.add("V");
        // Campo Músicas
        ArrayList<String> musicasDefecto = new ArrayList<>();
        musicasDefecto.add("F");
        musicasDefecto.add("P");
        // Campo Licencia
//        Boolean licencia = false;

        modelo.addAttribute("aficionesDefecto", aficionesDefecto);
        // Campo Paises
        modelo.addAttribute("pais_seleccionado", "F");
        modelo.addAttribute("musicasDefecto", musicasDefecto);
        // Titulo
        modelo.addAttribute("titulo", titulo);
        // Campo Usuario
        modelo.addAttribute("usuario", usuario);
        // Campo Licencia
        modelo.addAttribute("licencia", false);
        // Interacciones
        modelo.addAttribute("interaccion", interaccion);

        return "formulario";
    }

    @PostMapping("recibe-parametros")
    public String recibeParametros(
            @RequestParam(required = false) String usuario,
            @RequestParam(required = false) String clave,
            @RequestParam(required = false) String genero_seleccionado,
            @RequestParam(required = false) ArrayList<String> aficiones_seleccionadas,
            @RequestParam(required = false) String pais_seleccionado,
            @RequestParam(required = false) ArrayList<String> musicas_seleccionadas,
            @RequestParam(required = false) Boolean licencia,
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
        modelo.addAttribute("musicaArray", musicas_seleccionadas);
        modelo.addAttribute("licencia", licencia);
        modelo.addAttribute("interaccion", interaccion);

        return "formulario";
    }

}
