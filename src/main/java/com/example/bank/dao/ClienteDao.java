package com.example.bank.dao;

import com.example.bank.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

    @Query(value = ("Select * From clientes where usuario=:usuario"),nativeQuery = true)
    public List<Cliente> busquedaCliente (String usuario);
}
