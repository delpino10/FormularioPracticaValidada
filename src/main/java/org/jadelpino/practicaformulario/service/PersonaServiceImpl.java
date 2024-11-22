package org.jadelpino.practicaformulario.service;

import org.jadelpino.practicaformulario.model.DatosPersonas;
import org.jadelpino.practicaformulario.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Override
    public List<Persona> devuelveTodasPersonas() {
        return DatosPersonas.getListaPersonas();
    }

    @Override
    public Persona devuelvePersonaporIOd(Long id) {
        return null;
    }

    @Override
    public void crearPersona(Persona persona) {

    }

    @Override
    public void actualizarPersona(Persona persona) {

    }

    @Override
    public void eliminarPersona(Long id) {

    }
}
