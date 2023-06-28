package com.ejemplo.service;

import com.ejemplo.commons.ResourceNotFoundException;
import com.ejemplo.models.Pais;
import com.ejemplo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PaisServiceImpl implements  PaisService{
    @Autowired
    private PaisRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Pais> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pais getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("El pais con id:" + id+"no se encontro"));
    }

    @Override
    @Transactional
    public Pais save(Pais pais) {
        return repository.save(pais);
    }


    @Override
    public void deleteById(Long id) {
        Pais pais = repository.findById(id).orElse(null);
        if(pais == null){
            throw new ResourceNotFoundException("El pais con id: "+ id + "no se encontro");
        }
        repository.deleteById(id);
    }


    @Override
    public Pais update(Pais pais) {
        Pais paisDB = this.getById(pais.getId());
        if(paisDB==null){
            throw new ResourceNotFoundException("El Pais con id: " + pais.getId() + "no se encontro");
        }
        return  repository.save(pais);
    }
}