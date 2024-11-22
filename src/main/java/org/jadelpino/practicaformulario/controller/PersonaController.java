package org.jadelpino.practicaformulario.controller;

import org.jadelpino.practicaformulario.model.Persona;
import org.jadelpino.practicaformulario.service.PersonaService;
import org.jadelpino.practicaformulario.service.PersonaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("persona")
public class PersonaController {
    // Se declara un Objeto de la clase PersonaService
    // que se usará en todos los endpoints
    private final PersonaService personaServicio;
    // Constructor
    public PersonaController(PersonaService personaServicio) {
        this.personaServicio = personaServicio;
    }


    @GetMapping
    @ResponseBody
    public List<Persona> devuelveTodasPersonas(){
        // Nos va a devolver JSON al Navegador
        return  personaServicio.devuelveTodasPersonas();
    }

}
