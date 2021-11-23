package com.example.bank.repository;

import com.example.bank.entity.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CuentasRepository extends CrudRepository<Cuenta, Integer> {

    @Query(value = "SELECT * FROM CUENTAS c WHERE c.numCliente=:numCliente", nativeQuery = true)
    List<Cuenta> obtenerCuentas(int numCliente);
}