package com.example.bank.repository;

import com.example.bank.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface CuentaDao extends CrudRepository<Cliente, Integer> {
}
