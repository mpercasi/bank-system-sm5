package com.example.bank.service;

import com.example.bank.entity.Cliente;
import com.example.bank.repository.ClienteDao;
import com.example.bank.repository.PagoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteDao clienteDao;

    @Autowired

    private PagoDao pagoDao;


    public Optional<Cliente> getUsuario(String usuario, String contra) {
        return clienteDao.findClienteValidarUsuario(usuario, contra);
    }

    public Optional<Cliente> searchCliente(String usuario, String contra) {
        return clienteDao.findClienteValidarUsuario(usuario, contra);
    }

    public String searchContra(String usuario) {
        String contra = clienteDao.finClienteValidarcontra(usuario);
        return contra;

    }

    public void updateStatus(String estado, String nombre) {
        clienteDao.updateCustomer(estado, nombre);
    }

    public String validarStatus(String usuario) {
        return clienteDao.finClienteValidarstatus(usuario);
    }


    ///Metodos de pago

    public String getUsuarioPago(String usuario) {
        return clienteDao.findClienteValidarUsuarioPago(usuario);
    }
}

