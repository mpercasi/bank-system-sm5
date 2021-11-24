package com.example.bank.repository;

import com.example.bank.entity.Cuenta;
import com.example.bank.entity.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface PosicionRepository extends CrudRepository {
    @Query
            (value = "SELECT * FROM CUENTA u WHERE u.status = 1",
    nativeQuery = true)
    Collection<Cuenta> findAllActiveUsersNative();

}