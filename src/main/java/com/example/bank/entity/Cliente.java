package com.example.bank.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;

@Setter
@Getter
@Table( name = "clientes")
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private String nombre;
    private String contra;

    public Cliente(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }

    public Cliente()
    {

    }
}
