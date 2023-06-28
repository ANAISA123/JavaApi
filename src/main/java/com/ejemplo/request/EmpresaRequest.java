package com.ejemplo.request;

import com.ejemplo.models.Empresa;
import com.ejemplo.models.Persona;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class EmpresaRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    @Pattern(regexp = "^[0-9]{5,15}$", message = "Sólo debe contener números y su longitud debe ser mayor a 5.")
    private String nit;


    public Empresa toEmpresaModal(){
        Empresa empresa = new Empresa(
              this.getNombre(),
              this.getNit()
        );
         return empresa;
    }
}
