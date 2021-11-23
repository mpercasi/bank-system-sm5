package com.example.bank.controller;

import com.example.bank.entity.Cliente;
import com.example.bank.exception.*;
import com.example.bank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("MostrarTodosLosclientes")
    public List<Cliente> traerClientes() {
        return clienteRepository.traer();
    }

    @PostMapping("/CrearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente)
            throws ClienteExistenteException, MenorDeEdadException,
            TelefonoInvalidoException, CorreoInvalidoException,
            ContraLargoInvalidoException, ContraSinNumeroException, ContraSinAlfaException {
        String cli = cliente.getUsuario();
        clienteRepository.obtenerPorUsuario(cli);

        int varTel, varContra;
        String longitudTel = cliente.getCelular();
        String longitudContra = cliente.getContra();
        boolean a = cliente.getCorreo().contains("@");
        varTel = longitudTel.length();
        varContra = longitudContra.length();

        if (cliente.getEdad() >= 18) {

            if (varTel == 10) {

                if (cliente.getCorreo().contains("@")) {

                    if (varContra >= 6) {

                        if (clienteRepository.busquedaNumeros(cliente.getContra()).equals("ok")) {

                            if (clienteRepository.busquedaAlfanumericos(cliente.getContra()).equals("ok")) {

                                clienteRepository.crear(cliente);
                            } else {
                                throw new ContraSinAlfaException();
                            }
                        } else {
                            throw new ContraSinNumeroException();
                        }
                    } else {
                        throw new ContraLargoInvalidoException();
                    }
                } else {
                    throw new CorreoInvalidoException();
                }
            } else {
                throw new TelefonoInvalidoException();
            }
        } else {
            throw new MenorDeEdadException();
        }

        return ResponseEntity.ok(cliente);
    }
}
