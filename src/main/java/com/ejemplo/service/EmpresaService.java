package com.ejemplo.service;

import com.ejemplo.models.Empresa;
import com.ejemplo.models.Persona;

import java.util.List;

public interface EmpresaService {

    public List<Empresa> getAll();

    public Empresa getById(Long id);

    public Empresa save(Empresa empresa);

    public void deleteById(Long id);

    public Empresa update(Empresa empresa);
}
