package com.example.bank.service;

import com.example.bank.entity.Prestamo;
import com.example.bank.repository.PrestamoRepository;
import com.example.bank.repository.PrestamoRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.PushBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {


    @Autowired
    private PrestamoRepository prestamoRepository;


    public List<Prestamo> findAll() {
        return prestamoRepository.getPrestamo();
    }

    public void addPrestamo(Prestamo prestamo) {
        prestamoRepository.addPrestamo(prestamo);
    }

    public Optional<Prestamo> buscarPrestamo(Integer id) {
        return prestamoRepository.buscarPrestamo(id);
    }

    public Optional<Prestamo> getPrestamoByNumPrestamo(int numPrestamo) {
        return prestamoRepository.obtenerPrestamo(numPrestamo);
    }
}
