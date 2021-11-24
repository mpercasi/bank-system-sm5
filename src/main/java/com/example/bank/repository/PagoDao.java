package com.example.bank.repository;

import com.example.bank.entity.Cliente;
import com.example.bank.entity.Pago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoDao extends CrudRepository<Pago, Integer> {



    @Query(value = "select t.tarjetas from tarjetas t inner join t.clientes c where c.idcliente = t.idcliente  ", nativeQuery = true)

    //select t.num_tarjeta, t.status, t.Medio_Pago from tarjetas t join clientes c on c.idcliente = t.idcliente where  c.idcliente = t.idcliente
    public List<Pago> findClienteValidarUsuarios(String nombre);



}
