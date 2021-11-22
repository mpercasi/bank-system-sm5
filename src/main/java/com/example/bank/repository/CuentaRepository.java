package com.example.bank.repository;
import com.example.bank.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CuentaRepository {
    @Autowired
    private CuentaDao cuentaDao;

    public  List<Cuenta> getAll() {return (List<Cuenta>) cuentaDao.findAll();}
    public Optional<Cuenta> getbyId(Integer id){
        return cuentaDao.findById(id);
    }

    public List<Cuenta> getCuentas(Integer id){
        Cuenta cuenta = cuentaDao.findAll(id).get();
        return  cuenta.getCuentas();
    }

}

