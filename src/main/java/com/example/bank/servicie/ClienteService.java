package com.example.bank.servicie;

import com.example.bank.entity.Cliente;
import com.example.bank.repository.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private  List<Cliente> clientes =  new ArrayList<>();
@Autowired
    ClienteDao clienteDao;


    public List<Cliente> getUsuario(String usuario, String contra) {
        return clienteDao.findTeacherByNombreAndEdadPorJPQueryvalidarusuario(usuario,contra);
    }

    public List<Cliente> searchCliente(String usuario, String contra) {
    return clienteDao.findTeacherByNombreAndEdadPorJPQueryvalidarusuario(usuario,contra);
    }

    public String searchContra(String usuario) {
       return clienteDao.findClienteByContraPorJPQueryvalidarcontra(usuario);

    }
    public boolean statusCliente(Integer intentos)
    {
        for (int i=0; i<=4; i++ )
        {
            if (i>3)
            {
                return true;
            }
        }
        return  false;
    }
}
