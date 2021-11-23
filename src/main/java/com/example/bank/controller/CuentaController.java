package com.example.bank.controller;

import com.example.bank.entity.Cuenta;
import com.example.bank.exceptions.DuplicatedException;
import com.example.bank.exceptions.NonExistentException;
import com.example.bank.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = {"*"})
public class CuentaController {

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

    @PostMapping
    public ResponseEntity crearCuenta(@RequestBody Cuenta cuenta) throws DuplicatedException {
        List<Cuenta> cuentas = system.obtenerCuentas(cuenta.getNumCliente());
        if(system.validarEstatus(cuentas, cuenta.getTipo())){
            throw new DuplicatedException();
        }
        return ResponseEntity.ok(system.agregarCuenta(cuenta));
    }
}