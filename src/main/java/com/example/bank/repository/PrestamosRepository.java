package com.example.bank.repository;

import com.example.bank.entity.Cuenta;
import com.example.bank.entity.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PrestamosRepository extends  CrudRepository{
    @Query(value = "SELECT * FROM PRESTAMOS c WHERE c.numPrestamo=:numPrestamo", nativeQuery = true)
    List<Prestamo> obtenerPrestamos(int numPrestamo);
}
