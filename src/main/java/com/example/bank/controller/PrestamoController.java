package com.example.bank.controller;


import com.example.bank.entity.Cuenta;
import com.example.bank.entity.Prestamo;
import com.example.bank.exceptions.DuplicatedException;
import com.example.bank.exceptions.NonExistentException;
import com.example.bank.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@CrossOrigin(origins = {"*"})
public class PrestamoController {
    @Autowired
    private SystemService system;

    @GetMapping("/{numPrestamo}")
    public List<Prestamo> getPrestamos(@PathVariable int numPrestamo) throws NonExistentException {
        List<Prestamo> prestamos = system.obtenerPrestamo(numPrestamo);
        if (prestamos.isEmpty()){
            throw new NonExistentException();
        }
        return prestamos;
    }
}
