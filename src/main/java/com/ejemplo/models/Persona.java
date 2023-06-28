package com.ejemplo.models;

import lombok.*;

import javax.persistence.*;

@Getter//Este nos crea todos los get de los atributos.
@Setter//Este nos crea todos los set de los atributos.
@NoArgsConstructor//Este nos crea el constructor vacío.
@AllArgsConstructor//Este nos crea el constructor con todos los atributos.
@Entity //Esto nos mappea la clase a una tabla.
@Table(name = "personas")//Esto me cambia el nombre de la tabla en la base de datos.

public class Persona {
    @Id//Nos identifica que atributo es el id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para que el id sea autoincrementable.
    private Long id;

    private String nombre;

    private String apellido;

    private String documento;

    private String email;

    private int edad;

    public Persona(String nombre, String apellido, String documento, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.edad = edad;
    }


}
