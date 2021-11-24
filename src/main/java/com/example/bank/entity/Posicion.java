package com.example.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class Posicion {
    private Integer id;
    private String estado;
    private double monto;
    private String tipoMoneda;
    private String tipo;
    private double montoSobreGiro;
    private int mesesAhorro;
    private int numCliente;
    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name="Tarjetas")
    private List<Tarjeta> tarjetas = new ArrayList<>();
}
