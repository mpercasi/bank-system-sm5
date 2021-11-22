package com.example.bank.controller;

import com.example.bank.entity.Cliente;
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
    public List<Cliente> traerClientes(){
        return clienteRepository.traer();
    }

    @PostMapping("/CrearCliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        //Optional<Cliente> existeAlumno = clienteRepository.obtenerPorUsuario(cliente.getUsuario());
        String longitudTel = cliente.getCelular();
        String longitudContra = cliente.getContra();
        int var;
        if(cliente.getEdad()>=18){
            var = longitudTel.length();
            if(var == 10){
                clienteRepository.crear(cliente);
            }
        }
        return ResponseEntity.ok(cliente);
    }
}
