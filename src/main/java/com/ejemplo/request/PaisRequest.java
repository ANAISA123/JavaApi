package com.ejemplo.request;

import com.ejemplo.models.Pais;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PaisRequest {
    @NotBlank
    private String nombre;

    @NotBlank
    private String capital;

    @NotBlank
    @Pattern(regexp = "^[0-9]{5,15}",message="solo debe contener numeros y su longitud debe ser mayor a 5")
    private String moneda;


    private int habitantes;

    public Pais toPaisModel(){
        Pais pais=new Pais(
        this.getNombre(),
        this.getCapital(),
        this.getHabitantes(),
        this.getMoneda()
        );
        return pais;
    }
}
