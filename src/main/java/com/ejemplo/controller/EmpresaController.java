package com.ejemplo.controller;

import com.ejemplo.models.Empresa;
import com.ejemplo.request.EmpresaRequest;
import com.ejemplo.service.EmpresaService;
import com.ejemplo.web.ResponseOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController//
@RequestMapping("/empresas")//
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @GetMapping
    public ResponseEntity<ResponseOk> getAll() {
        return ResponseOk.createResponse(HttpStatus.OK,  "Listado Empresas", service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOk> getById(@PathVariable Long id) {

        return ResponseOk.createResponse(HttpStatus.OK, "Empresa con id: " + id, service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseOk> save(@RequestBody @Valid EmpresaRequest empresaRequest) {
        Empresa empresaBD = service.save(empresaRequest.toEmpresaModal());
        return ResponseOk.createResponse(HttpStatus.OK, "Empresa nueva creada ", service.save(empresaBD) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseOk> update(@Valid @RequestBody EmpresaRequest empresaRequest, @PathVariable Long id) {
        Empresa empresaUpdate = empresaRequest.toEmpresaModal();
        empresaUpdate.setId(id);
        return ResponseOk.createResponse(HttpStatus.OK, "Empresa con id " + id + " actualizada ", service.update(empresaUpdate) );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseOk> deleteById( @PathVariable Long id) {
        service.deleteById(id);
        return ResponseOk.createResponse(HttpStatus.OK, "Empresa eliminada correctamente", null );

    }
}
