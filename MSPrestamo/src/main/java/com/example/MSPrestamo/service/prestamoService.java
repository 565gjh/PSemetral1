package com.example.MSPrestamo.service;


import com.example.MSPrestamo.model.Prestamo;
import com.example.MSPrestamo.repository.prestamoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class prestamoService {

    @Autowired
    private prestamoRepository repository;

    public List<Prestamo> findAll() {
        log.info("Obteniendo lista de todos los préstamos.");
        return repository.findAll();
    }

    public Prestamo findById(Long id) {
        log.info("buscando prestamo por id.");
        return repository.findById(id).orElse(null);
    }

    public Prestamo save(Prestamo prestamo) {
        log.info("Guardando el préstamo.");
        return repository.save(prestamo);
    }

    public void delete(Long id) {
        log.info("eliminando el préstamo seleccionado.");
        repository.deleteById(id);
    }
}
