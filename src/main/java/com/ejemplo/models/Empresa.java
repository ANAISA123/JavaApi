package com.ejemplo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresa")

public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que el id sea autoincrementable.
    private Long id;

    private String nombre;

    private String nit;


    public Empresa(String nombre,String nit){
        this.nombre = nombre;
        this.nit = nit;
    }

}
