package com.example.bank.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Cuentas")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "Cuentas", nullable = true)
    private List<Cuenta> cuentas;


}
