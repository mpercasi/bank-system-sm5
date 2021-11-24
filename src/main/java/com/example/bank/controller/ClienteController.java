package com.example.bank.controller;

import com.example.bank.entity.Cliente;
import com.example.bank.exceptions.NonExistentCustomer2Exception;
import com.example.bank.exceptions.NonExistentCustomerException;
import com.example.bank.repository.PagoDao;
import com.example.bank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private PagoDao servicePago;

    @GetMapping("/cliente/{usuarios}/{contras}")
    public ResponseEntity<String> getUsuario(@PathVariable("usuarios") String usuario, @PathVariable("contras") String contra) throws NonExistentCustomerException, NonExistentCustomer2Exception {
        Optional<Cliente> cliente = service.getUsuario(usuario, contra);

        Integer contador = 0;
        String estado = "Bloqueado";
        String estado2 = "Desbloqueado";
        String dato = service.searchContra(usuario);


        if (usuario.isEmpty()) {
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
        contador++;
        throw new NonExistentCustomer2Exception();

    }



    //Metodo de pago
    @GetMapping("/clientePago/{usuarios}")
    public ResponseEntity<String> getUsuarioPago(@PathVariable("usuarios") String usuario) throws NonExistentCustomerException {
        String cliente = service.getUsuarioPago(usuario);
        String validarUsuario= String.valueOf(cliente);


        if (usuario.isEmpty()) {

            throw new NonExistentCustomerException();
        }



        if(validarUsuario.equals(usuario))
        {
            return ResponseEntity.ok("Usuario correcto");

        }

        throw new NonExistentCustomerException();
    }

}
