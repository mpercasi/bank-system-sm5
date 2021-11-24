package com.example.bank.service;

import com.example.bank.entity.Cuenta;
import com.example.bank.entity.Prestamo;
import com.example.bank.repository.CuentasRepository;
import com.example.bank.repository.PrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {
    @Autowired
    private CuentasRepository cuentasRepository;
    @Autowired
    private PrestamosRepository prestamosRepository;

    public List<Cuenta> obtenerCuentas(int numCliente) {
        return cuentasRepository.obtenerCuentas(numCliente);
    }

    public List<Prestamo> obtenerPrestamo(int numPrestamo) {
        return prestamosRepository.obtenerPrestamos(numPrestamo);
    }

    public boolean validarEstatus(List<Cuenta> cuentas, String tipoCuentaSolicitada) {
        for (Cuenta c : cuentas) {
            if (c.getTipo() == tipoCuentaSolicitada){
                return true;
            }
        }
        return false;
    }

    public Cuenta agregarCuenta(Cuenta cuenta) {
        cuentasRepository.save(cuenta);
        return cuenta;
    }

    public Prestamo obtenerPrestamo(Prestamo prestamo){
        prestamosRepository.save(prestamo);
        return prestamo;
    }

    public Prestamo crearPrestamo(Prestamo prestamo){
        prestamosRepository.save(prestamo);
        return prestamo;
    }
}