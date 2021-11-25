package com.example.bank.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Setter
@Getter
@Table(name = "Tarjetas")
public class TarjetaDebito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private  int numTarjeta;
    private String medioPago;
    private String  status;
    private String nombreCliente;

    private TarjetaDebito()
    {

    }

    public TarjetaDebito(Integer id, int numTarjeta, String medioPago, String status,String nombreCliente) {
        this.id = id;
        this.numTarjeta = numTarjeta;
        this.medioPago = medioPago;
        this.status = status;
        this.nombreCliente=nombreCliente;
    }
}
