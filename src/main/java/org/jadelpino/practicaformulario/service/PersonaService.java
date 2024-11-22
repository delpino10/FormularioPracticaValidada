package org.jadelpino.practicaformulario.service;

import org.jadelpino.practicaformulario.model.Persona;

import java.util.List;

public interface PersonaService {
    List<Persona> devuelveTodasPersonas();
    Persona devuelvePersonaporIOd(Long id);
    void crearPersona(Persona persona);
    void actualizarPersona(Persona persona);
    void eliminarPersona(Long id);
}
