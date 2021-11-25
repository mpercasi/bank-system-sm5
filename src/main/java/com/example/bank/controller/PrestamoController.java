package com.example.bank.controller;

import com.example.bank.entity.Prestamo;
import com.example.bank.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiPrestamo")


public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;
    @PostMapping("/Prestamo")
    public ResponseEntity<String> addPrestamo (@RequestBody Prestamo prestamo){
        Optional<Prestamo> prestamo1 = prestamoService.buscarPrestamo(prestamo.getId());
        if (prestamo.getSaldo() >= 20000){
            prestamoService.addPrestamo(prestamo);
            return ResponseEntity.ok("El Prestamo fue realizado con éxito.");
        }
        else {
            return ResponseEntity.status(500).body("no cuentas con el saldo suficiene para realizar un prestamo");
        }
    }

    @GetMapping("/Prestamos")
    public List<Prestamo> allPrestamos() {
        return (List<Prestamo>) prestamoService.findAll();
    }

    @GetMapping("/{numPrestamo}")
    public Prestamo getPrestamos(@PathVariable("numPrestamo") int numPrestamo) {
        Optional <Prestamo> prestamo = prestamoService.getPrestamoByNumPrestamo(numPrestamo);
        if (prestamo.isPresent()){
            return prestamo.get();
        }
        else {
//            meter exception
            return null;
        }
    }
}
