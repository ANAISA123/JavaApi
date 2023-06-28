package com.ejemplo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String capital;
    private int habitantes;
    private String moneda;

    public Pais(String nombre, String capital, int habitantes, String moneda) {
        this.id = id;
        this.nombre = nombre;
        this.capital = capital;
        this.habitantes = habitantes;
        this.moneda = moneda;
    }
}
