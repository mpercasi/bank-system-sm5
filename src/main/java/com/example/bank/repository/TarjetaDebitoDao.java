package com.example.bank.repository;

import com.example.bank.entity.TarjetaDebito;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarjetaDebitoDao extends CrudRepository<TarjetaDebito, Integer> {

    @Query(value = "select num_tarjeta from tarjetas where num_tarjeta=:num_tarjeta", nativeQuery = true)
    public String findTarjetasValidarTarjeta(@Param("num_tarjeta") Integer numTarjeta);

    @Query(value = "select status from tarjetas where nombre_cliente=:nombre_cliente and num_tarjeta=:num_tarjeta",nativeQuery = true)
    public String findTarjetasByNombreAndNumValidarstatus(@Param("nombre_cliente") String nombreCliente, @Param("num_tarjeta") Integer num_tarjeta);

    @Query(value = "select medio_pago from tarjetas where nombre_cliente=:nombre_cliente and num_tarjeta=:num_tarjeta",nativeQuery = true)
    public String  findTarjetasByNombreAndNumValidarMedioDePago(@Param("nombre_cliente") String nombreCliente, @Param("num_tarjeta") Integer num_tarjeta);


    @Modifying
    @Query(value = "UPDATE tarjetas SET medio_pago=:medio_pago WHERE num_tarjeta=:num_tarjeta ", nativeQuery = true)
    void updateTarjetaStatusPago(@Param("medio_pago") String medio_pago, @Param("num_tarjeta") Integer num_Tarjeta);

    @Query(value = "select num_tarjeta from tarjetas where nombre_cliente=:nombre_cliente and num_tarjeta=:num_tarjeta",nativeQuery = true)
    public String findTarjetasByNombreAndNumValidarTarjeta(@Param("nombre_cliente") String nombreCliente, @Param("num_tarjeta") Integer num_tarjeta);

}
