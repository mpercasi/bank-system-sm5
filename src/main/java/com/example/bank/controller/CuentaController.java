package com.example.bank.controller;

import com.example.bank.entity.Cuenta;
import com.example.bank.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;


    @GetMapping("/mostrarCuenta/{id}")
    public ResponseEntity<List<Cuenta>> getCuentas(@PathVariable("id") Integer dni) {
        Optional<Cuenta> cliente = cuentaRepository.getbyId(id);

        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(CuentaRepository.getCuentas(dni));
        }

    }
}
