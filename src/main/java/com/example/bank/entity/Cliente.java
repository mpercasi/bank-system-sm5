package com.example.bank.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table( name = "clientes")
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer idcliente;

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

    public void getSaldo() {
    }
}
