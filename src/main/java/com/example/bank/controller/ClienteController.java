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

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;


    @GetMapping("/cliente/{usuarios}/{contra}")
    public ResponseEntity<Cliente> getUsuario(@PathVariable("usuarios") String usuario, @PathVariable("contra") String contra) throws NonExistentCustomerException, NonExistentCustomer2Exception{
        List<Cliente> cliente = service.getUsuario(usuario, contra);
        String dato = service.searchContra(usuario);
        Integer contador = 0;

        //Valida si los campos estan vacios
        if (cliente.isEmpty()) {
            throw new NonExistentCustomerException();
        }

        if (service.searchContra(usuario) != contra) {

            System.out.println("Contarseña incorrecta");
            contador +=contador;
        }
        if (service.statusCliente(contador)== true);
        {
            System.out.println("tu cuenta se ha bloqueadp");
        }

        return ResponseEntity.ok(cliente.get(0));



    }
}
