package com.ejemplo.service;

import com.ejemplo.commons.ResourceNotFoundException;
import com.ejemplo.models.Empresa;
import com.ejemplo.models.Pais;
import com.ejemplo.models.Persona;
import com.ejemplo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service//Sirve para  indicarle a spring que este es un servicio.
public class PersonaServiceImpl implements PersonaService {

    @Autowired//para que spring vaya y busque el componente que necesito.
    private PersonaRepository repository;

    @Autowired
    private PaisService paisService;

    @Autowired
    private EmpresaService empresaService;


    @Override
    @Transactional(readOnly = true)
    public List<Persona> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona getById(Long id) {
      return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("La persona con id " + id + " no se encontró"));

    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        Pais paisDB = paisService.getById(persona.getPais().getId());
        persona.setPais(paisDB);

        Empresa empresaDB = empresaService.getById(persona.getEmpresa().getId());
        persona.setEmpresa(empresaDB);
        return repository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        Persona personaBD = this.getById(persona.getId());

        if (personaBD == null){
            throw new ResourceNotFoundException("La persona con id " + persona.getId() + " no se encontró");
        }
        return repository.save(persona);
    }

   @Override
   @Transactional
    public void deleteById(Long id) {
       Persona persona = repository.findById(id).orElse(null);
       if (persona == null){
           throw new ResourceNotFoundException("La persona con id " + id + " no se encontró");
       }
       repository.deleteById(id);
   }

}
