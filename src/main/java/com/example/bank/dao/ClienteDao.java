package com.example.bank.dao;

import com.example.bank.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
