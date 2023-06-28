package com.ejemplo.controller;

import com.ejemplo.models.Pais;
import com.ejemplo.request.PaisRequest;
import com.ejemplo.service.PaisService;
import com.ejemplo.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisService service;


    @GetMapping
    public ResponseEntity<ResponseOk> getAll(){
        return  ResponseOk.createResponse(HttpStatus.OK,"Listado de paises",service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk>  getById(@PathVariable Long id){

        return ResponseOk.createResponse(HttpStatus.OK,"Pais con id: "+id,service.getById(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseOk> deleteById(@PathVariable Long id){
        service.deleteById(id);

        return ResponseOk.createResponse(HttpStatus.OK, "Se elimino el pais", null);
    }
    @PostMapping
    public ResponseEntity<ResponseOk> create(@Valid @RequestBody PaisRequest paisRequest){
        return  ResponseOk.createResponse(HttpStatus.OK,"pais creado ",service.save(paisRequest.toPaisModel()));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ResponseOk> update(@Valid @RequestBody PaisRequest paisRequest, @PathVariable Long id) {
        Pais paisUpdate=paisRequest.toPaisModel();//objeto para actualizar
        paisUpdate.setId(id);
        return ResponseOk.createResponse(HttpStatus.OK,"Pais Actualizado",service.update(paisUpdate));
    }
}
