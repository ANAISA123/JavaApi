package com.ejemplo.service;

import com.ejemplo.commons.ResourceNotFoundException;
import com.ejemplo.models.Empresa;
import com.ejemplo.models.Persona;
import com.ejemplo.repository.EmpresaRepository;
import com.ejemplo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired//para que spring vaya y busque el componente que necesito.
    private EmpresaRepository repository;
    @Override
    public List<Empresa> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empresa getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("La Empresa con id " + id + " no se encontró"));

    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return repository.save(empresa);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Empresa empresa = repository.findById(id).orElse(null);
        if (empresa == null){
            throw new ResourceNotFoundException("La Empresa con id " + id + " no se encontró");
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Empresa update(Empresa empresa) {

        Empresa empresaBD = this.getById(empresa.getId());

        if (empresaBD == null){
            throw new ResourceNotFoundException("La Empresa con id " + empresa.getId() + " no se encontró");
        }
        return repository.save(empresa);
    }
}
