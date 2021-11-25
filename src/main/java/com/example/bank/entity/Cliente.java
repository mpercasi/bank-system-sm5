package com.example.bank.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Table( name = "clientes")
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer idcliente;

    /*//Con este mapeo me permite usar de manera implicita los Joins
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "FkTarjeta")
    private Set<TarjetaDebito> id;*/


    private String nombre;
    private String contra;
    private String status;



    public Cliente(String nombre, String contra, String status) {
        this.nombre = nombre;
        this.contra = contra;
        this.status = status;

    }

    public Cliente()
    {

    }
}
