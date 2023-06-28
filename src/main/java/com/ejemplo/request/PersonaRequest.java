package com.ejemplo.request;

import com.ejemplo.models.Persona;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    public Persona toPersonaModel(){
        Persona persona = new Persona(
                this.getNombre(),
                this.getApellido(),
                this.getDocumento(),
                this.getEmail(),
                this.getEdad()
        );
        return persona;
    }

}
