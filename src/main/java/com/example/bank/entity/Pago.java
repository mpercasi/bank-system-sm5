package com.example.bank.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@Table(name = "Pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    private Integer numPago;
    private String  status;



    public Pago()
    {

    }

    public Pago(Integer numTarjeta,String status) {
        this.numPago = numTarjeta;
        this.status = status;
    }
}
