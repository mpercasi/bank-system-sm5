package com.example.bank.controller;

import com.example.bank.entity.Cliente;
import com.example.bank.exception.NonExistentCustomer2Exception;
import com.example.bank.exception.NonExistentCustomerException;
import com.example.bank.servicie.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/cliente/{usuarios}/{contras}")
    public ResponseEntity<String> getUsuario(@PathVariable("usuarios") String usuario, @PathVariable("contras") String contra) throws NonExistentCustomerException, NonExistentCustomer2Exception {
        Optional<Cliente> cliente = service.getUsuario(usuario, contra);

        Integer contador = 0;
        String estado = "Bloqueado";
        String estado2 = "Desbloqueado";
        String dato = service.searchContra(usuario);
        Cliente cl = new Cliente();

        if (usuario == null) {
            throw new NonExistentCustomerException();
        }

        if (estado.equals(service.validarStatus(usuario))) {
            return ResponseEntity.ok("Lo sentimos tu usuario esta bloqueado");
        }

        if (dato.equals(contra)) {

                return ResponseEntity.ok("Usuario correcto");
        }

        //Valida si la contraseña no es correcta
        if (contra != dato) {

            contador = contador + 1;

            if (contador >2) {
                service.updateStatus(estado, usuario);
            } else
                service.updateStatus(estado2, usuario);
        }

        throw new NonExistentCustomer2Exception();

    }
}
