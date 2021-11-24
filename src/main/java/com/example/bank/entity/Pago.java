package com.example.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import  javax.persistence.*;
import java.util.List;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@Table(name = "Pagos")
public class Pago {

    @javax.persistence.Id
    @GeneratedValue
    private Integer Id;

    private Integer numTarjeta;
    private String  status;



    public Pago()
    {

    }

    public Pago(Integer numTarjeta,String status) {
        this.numTarjeta = numTarjeta;
        this.status = status;
    }
}