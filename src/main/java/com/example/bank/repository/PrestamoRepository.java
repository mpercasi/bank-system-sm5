package com.example.bank.repository;

import com.example.bank.entity.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface PrestamoRepository {
    List<Prestamo> getPrestamo();

    void addPrestamo(Prestamo prestamo);

    Optional<Prestamo> buscarPrestamo(Integer id);
    @Query(value = "SELECT t.numPrestamo from Prestamo t WHERE t.id=:id")



    Optional<Prestamo> obtenerPrestamo(int numPrestamo);
    @Query(value = "SELECT t.monto from Prestamo t WHERE t.id=:id")
    Optional<Prestamo> getPrestamoById (Integer id);
}
