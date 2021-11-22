package com.example.bank.repository;

import com.example.bank.dao.ClienteDao;
import com.example.bank.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    @Autowired
    private ClienteDao clienteDao;

    public Optional<Cliente> obtenerPorUsuario(String usuario){
        return null;
    }

    public List<Cliente> traer(){
        return (List<Cliente>) clienteDao.findAll();
    }

    public Cliente crear(Cliente cliente){
        clienteDao.save(cliente);
        return cliente;
    }
}
