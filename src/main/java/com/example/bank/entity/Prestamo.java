package com.example.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="Prestamos")

public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String estado;
    private double monto;
    private int numPrestamo;
    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name="Prestamos")
    private List<Prestamo> obtenerPrestamos = new ArrayList<>();
}
