package com.example.bank.controller;

import com.example.bank.entity.Cuenta;
import com.example.bank.exceptions.NonExistentException;
import com.example.bank.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PosicionController {
    @Autowired
    private SystemService system;

    @GetMapping("/{numCliente}")
    public List<Cuenta> getCuentas(@PathVariable int numCliente) throws NonExistentException {
        List<Cuenta> cuentas = system.obtenerCuentas(numCliente);
        if (cuentas.isEmpty()){
            throw new NonExistentException();
        }
        return cuentas;
    }
}
