package com.example.bank.repository;

import com.example.bank.entity.Cliente;
import com.example.bank.entity.Pago;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PagoDao extends CrudRepository<Pago, Integer> {


    @Query(value ="select status from pagos where num_pago=:num_pago", nativeQuery = true)
    public String findPagoconsultarstatus(@Param("num_pago") Integer numpago);

    @Query(value = "select num_pago from pagos where num_pago=:num_pago", nativeQuery = true)
    public Integer  finPagoValidarNumPago(@Param("num_pago")  Integer numpago);

    @Modifying
    @Query(value = "UPDATE pagos SET status =:status WHERE num_pago=:num_pago ", nativeQuery = true)
    void updateStatusPago(@Param("status") String status, @Param("num_pago") Integer numpago);




  /*  @Query(value = "select*from tarjeta where nombre_cliente=:nombre_cliente and num_tarjeta=:num_tarjeta",nativeQuery = true)
    public List<Pago> findTarjetasVigentes(String nombrecliente, Integer num_tarjeta);*/

   /* @Query(value = "select status from tarjeta where nombre_cliente=:nombre_cliente and num_tarjeta=:num_tarjeta",nativeQuery = true)
    public String findTarjetasValidarstatus(String nombreCliente, Integer num_tarjeta);*/

  /*  @Query(value = "select medio_pago from tarjeta where nombre_cliente=:nombre_cliente and num_tarjeta=:num_tarjeta",nativeQuery = true)
    public boolean findTarjetasValidarMedioPago(String nombrecliente, Integer num_tarjeta);*/



   /* @Query(value = "select tj.num_tarjeta, tj.status, tj.medio_pago \n" +
            "from tarjetas as tj inner join  \n" +
            "Clientes as cl  on \n" +
            "cl.idcliente = tj.id\n" +
            "where cl.nombre =:nombre", nativeQuery = true)
    public List<Pago> findClienteValidarUsuarios(String nombre);*/

    //select t.num_tarjeta, t.status, t.Medio_Pago from tarjetas t join clientes c on c.idcliente = t.idcliente where  c.idcliente = t.idcliente
    //public List<Pago> findClienteValidarUsuarios(String nombre);



}
