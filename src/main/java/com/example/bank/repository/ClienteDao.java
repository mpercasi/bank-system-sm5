package com.example.bank.repository;

import com.example.bank.entity.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClienteDao extends CrudRepository<Cliente, Integer> {

    @Query(value = "select * from clientes where nombre= :nombre and contra=:contra", nativeQuery = true)
    public List<Cliente> findTeacherByNombreAndEdadPorJPQueryvalidarusuario(String nombre, String contra);


    @Query(value = "select contra from clientes where nombre =:nombre ", nativeQuery = true)
    public String  findClienteByContraPorJPQueryvalidarcontra(String nombre);


}
