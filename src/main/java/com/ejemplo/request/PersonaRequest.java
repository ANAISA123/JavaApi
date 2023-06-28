package com.ejemplo.request;

import com.ejemplo.models.Empresa;
import com.ejemplo.models.Pais;
import com.ejemplo.models.Persona;
import com.ejemplo.service.PaisService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
public class PersonaRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    @Pattern(regexp = "^[0-9]{5,15}$", message = "Sólo debe contener números y su longitud debe ser mayor a 5.")
    private String documento;

    @Email
    private String email;

    private int edad;

    @NotNull
    private Long pais_id;

    @NotNull
    private Long empresa_id;

    public Persona toPersonaModel(){
        Pais pais = new Pais();
        pais.setId(this.pais_id);
        Empresa empresa = new Empresa();
        empresa.setId(this.empresa_id);

        Persona persona = new Persona(
                this.getNombre(),
                this.getApellido(),
                this.getDocumento(),
                this.getEmail(),
                this.getEdad(),
                pais,
                empresa
        );
        return persona;
    }

}
