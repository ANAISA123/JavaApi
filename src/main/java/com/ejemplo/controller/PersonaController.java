package com.ejemplo.controller;

import com.ejemplo.models.Persona;
import com.ejemplo.request.PersonaRequest;
import com.ejemplo.service.PersonaService;
import com.ejemplo.web.ResponseError;
import com.ejemplo.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//
@RequestMapping("/personas")//
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK,  "Listado personas", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {
        
        return ResponseOk.createResponse(HttpStatus.OK, "Persona con id: " + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> save(@RequestBody @Valid PersonaRequest personaRequest) {
            Persona personaBD = service.save(personaRequest.toPersonaModel());
            return ResponseOk.createResponse(HttpStatus.OK, "Persona nueva creada ", service.save(personaBD) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseOk> update(@Valid @RequestBody PersonaRequest personaRequest, @PathVariable Long id) {
        Persona personaUpdate = personaRequest.toPersonaModel();
        personaUpdate.setId(id);
        return ResponseOk.createResponse(HttpStatus.OK, "Personacon id " + id + " actualizada ", service.update(personaUpdate) );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseOk> deleteById( @PathVariable Long id) {
         service.deleteById(id);
        return ResponseOk.createResponse(HttpStatus.OK, "Persona eliminada correctamente", null );

    }
}


