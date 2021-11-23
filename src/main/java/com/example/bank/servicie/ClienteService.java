package com.example.bank.servicie;

import com.example.bank.entity.Cliente;
import com.example.bank.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private  List<Cliente> clientes =  new ArrayList<>();
@Autowired
    ClienteDao clienteDao;


    public Optional <Cliente> getUsuario(String usuario, String contra) {
        return clienteDao.findTeacherByNombreAndEdadPorJPQueryvalidarusuario(usuario,contra);
    }

    public Optional <Cliente> searchCliente(String usuario, String contra) {
    return clienteDao.findTeacherByNombreAndEdadPorJPQueryvalidarusuario(usuario,contra);
    }

    public String searchContra(String usuario) {
        String contra = clienteDao.findClienteByContraPorJPQueryvalidarcontra(usuario) ;
       return contra;

    }

}
