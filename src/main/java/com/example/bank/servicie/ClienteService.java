package com.example.bank.servicie;

import com.example.bank.entity.Cliente;
import com.example.bank.entity.Pago;
import com.example.bank.entity.TarjetaDebito;
import com.example.bank.repository.ClienteDao;
import com.example.bank.repository.PagoDao;
import com.example.bank.repository.TarjetaDebitoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteDao clienteDao;

    @Autowired

    private PagoDao pagoDao;

    @Autowired
    private TarjetaDebitoDao debitoDao;


    public Optional<Cliente> getUsuario(String usuario, String contra) {
        return clienteDao.findClienteValidarUsuario(usuario, contra);
    }

    public Optional<Cliente> searchCliente(String usuario, String contra) {
        return clienteDao.findClienteValidarUsuario(usuario, contra);
    }

    public String searchContra(String usuario) {
        String contra = clienteDao.finClienteValidarcontra(usuario);
        return contra;

    }

    public void updateStatus(String estado, String nombre) {
        clienteDao.updateCustomer(estado, nombre);
    }

    public String validarStatus(String usuario) {
        return clienteDao.finClienteValidarstatus(usuario);
    }



    ///Metodos de pago

    public String getUsuarioPago(String usuario) {
        return clienteDao.findClienteValidarUsuarioPago(usuario);
    }


    public String getTarjetaValidarStatus(String usuario, Integer numTarjeta) {
        return debitoDao.findTarjetasByNombreAndNumValidarstatus(usuario,numTarjeta);
    }

    public String getTarjetaMediodePago(String usuario, Integer numTarjeta) {
       return  debitoDao.findTarjetasByNombreAndNumValidarMedioDePago(usuario,numTarjeta);

    }


    public String getTarjetaDebito(Integer numTarjeta) {
      return debitoDao.findTarjetasValidarTarjeta(numTarjeta);

    }

    public void updateTarjetaStausMedio( TarjetaDebito tarjetaDebito) {
         debitoDao.updateTarjetaStatusPago(tarjetaDebito.getMedioPago(),tarjetaDebito.getNumTarjeta());
    }

    public String validarTarjetaUsuario(String nombreCliente, Integer numTrajeta) {
        return debitoDao.findTarjetasByNombreAndNumValidarTarjeta(nombreCliente,numTrajeta);
    }

    //Metodos de pago


    public void updateStatusPago(Integer numeroPago, String status) {

         pagoDao.updateStatusPago(status,numeroPago);
    }

    public String getTarjetaConsultarStatusPago(Integer numPago){
        return pagoDao.findPagoconsultarstatus(numPago);
    }

    public Integer searchNumPago(Integer numPago) {

        return pagoDao.finPagoValidarNumPago(numPago);

    }



}
