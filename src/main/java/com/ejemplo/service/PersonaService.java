package com.ejemplo.service;

import com.ejemplo.models.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> getAll();

    public Persona getById(Long id);

    public Persona save(Persona persona);

    public void deleteById(Long id);

    public Persona update(Persona persona);
}
