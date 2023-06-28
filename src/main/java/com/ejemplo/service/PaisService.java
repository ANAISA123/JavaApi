package com.ejemplo.service;

import com.ejemplo.models.Pais;

import java.util.List;

public interface PaisService {
     public List<Pais> getAll();

    public Pais getById(Long id);

    public  Pais save(Pais pais);

    public void deleteById(Long id);

    public Pais update(Pais pais);

}
