package com.example.bank.controller;

import com.example.bank.entity.Cliente;
import com.example.bank.entity.Pago;
import com.example.bank.entity.TarjetaDebito;
import com.example.bank.exception.NonExistentCustomer2Exception;
import com.example.bank.exception.NonExistentCustomerException;
import com.example.bank.exception.NonExisteteTarjetaDebito;
import com.example.bank.repository.PagoDao;
import com.example.bank.repository.TarjetaDebitoDao;
import com.example.bank.servicie.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private PagoDao servicePago;

    @Autowired
    private TarjetaDebitoDao tarjetaDebitoDao;

    @GetMapping("/cliente/{usuarios}/{contras}")
    public ResponseEntity<String> getUsuario(@PathVariable("usuarios") String usuario, @PathVariable("contras") String contra) throws NonExistentCustomerException, NonExistentCustomer2Exception {
        Optional<Cliente> cliente = service.getUsuario(usuario, contra);

        Integer contador = 0;
        String estado = "Bloqueado";
        String estado2 = "Desbloqueado";
        String dato = service.searchContra(usuario);


        if (usuario.isEmpty()) {
            throw new NonExistentCustomerException();
        }

        if (estado.equals(service.validarStatus(usuario))) {
            return ResponseEntity.ok("Lo sentimos tu usuario esta bloqueado");
        }

        if (dato.equals(contra)) {

            return ResponseEntity.ok("Usuario correcto");
        }

        //Valida si la contraseña no es correcta
        if (contra != dato) {

            contador = contador + 1;

            if (contador > 2) {
                service.updateStatus(estado, usuario);
            } else
                service.updateStatus(estado2, usuario);
        }
        contador++;
        throw new NonExistentCustomer2Exception();

    }


    //Metodo de pago
    @GetMapping("/clientePago/{usuario}/{numTarjeta}/{numPago}")
    public ResponseEntity<String> getUsuarioPago(@PathVariable("usuario") String usuario, @PathVariable("numTarjeta") Integer numTarjeta, @PathVariable("numPago") Integer numeroPago) throws NonExistentCustomerException, NonExisteteTarjetaDebito {
        //Metodos para validar si existe  usuario
        String cliente = service.getUsuarioPago(usuario);
        String validarUsuario = String.valueOf(cliente);

        //Metods para validar Si existe NUMPAGO
        Integer validarNumPago = service.searchNumPago(numeroPago);

        //Metodos para pagos
        String estadoTrajeta = service.getTarjetaValidarStatus(usuario, numTarjeta);
        String mediodePago = service.getTarjetaMediodePago(usuario, numTarjeta);
        String validarTarjeta = service.getTarjetaDebito(numTarjeta);

        String estadoPagado = "PAGADO";
        String estadoFallido = "PAGADO";


        if (usuario.isEmpty() || numTarjeta == null || numeroPago == null) {

            throw new NonExistentCustomerException();
        }


        if (validarUsuario.equals(usuario) /*&& validarNumPago.equals(numeroPago)*/) {


            if (estadoTrajeta.equalsIgnoreCase("vigente") && mediodePago.equalsIgnoreCase("mediodepago")) {

                String consultaStatusPago = service.getTarjetaConsultarStatusPago(numeroPago);

                if (consultaStatusPago.equalsIgnoreCase("Pagado")) {
                    return ResponseEntity.ok("Ya se realizo el pago a esta referencia ");
                } else
                    service.updateStatusPago(numeroPago, estadoPagado);
                return ResponseEntity.ok("Transaccion realizada, estado:'PAGADO' ");

            } else
                service.updateStatusPago(numeroPago, estadoFallido);
            return ResponseEntity.ok("Transaccion rechazada, estado 'FALLIDO'");
        }


        throw new NonExisteteTarjetaDebito();
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody TarjetaDebito tarjeta) throws NonExistentCustomerException{

        String  validacion = service.validarTarjetaUsuario(tarjeta.getNombreCliente(), tarjeta.getNumTarjeta());

        if (service.getTarjetaMediodePago(tarjeta.getMedioPago(), tarjeta.getNumTarjeta()).isEmpty()){
            throw new NonExistentCustomerException();
        }

        if(validacion.equals(tarjeta.getNumTarjeta()))
        {
            return ResponseEntity.ok("No cuentas con esta tarjeta");
        }
        service.updateTarjetaStausMedio(tarjeta);
        return ResponseEntity.ok("Customer updated successfully!");
    }
}
