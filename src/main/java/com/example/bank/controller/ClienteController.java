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
    public ResponseEntity<String> getUsuario(@PathVariable("usuarios") String usuario, @PathVariable("contras") String contra) throws NonExistentCustomerException, NonExistentCustomer2Exception{
        Optional< Cliente> cliente = service.getUsuario(usuario, contra);

        Cliente cl = new Cliente();

        String dato = service.searchContra(usuario);
        Integer contador = 0;


        if(usuario == null)
        {
            throw new NonExistentCustomerException();
        }

        if(dato.equals(contra)) {
            return ResponseEntity.ok("Usuario correcto");

        }

        //Valida si los campos estan vacios
        if (contra != dato) {
            contador +=contador;
            if (contador > 3)
            {
               cl.setStatus ("bloqueado");
            }
            else
                cl.setStatus("libre");

            throw new NonExistentCustomer2Exception();
        }

return ResponseEntity.ok(usuario);

    }
}
