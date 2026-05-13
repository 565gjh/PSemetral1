package com.example.MSMultas.service;


import com.example.MSMultas.model.Multa;
import com.example.MSMultas.repository.multaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class multaService {

    @Autowired
    private multaRepository repository;

    public List<Multa> findAll() {
        log.info("Obteniendo lista de todas las multas.");
        return repository.findAll();
    }

    public Multa findById(Long id) {
        log.info("buscando multa por id.");
        return repository.findById(id).orElse(null);
    }

    public Multa save(Multa multa) {
        log.info("Guardando la multa.");
        // Si la fecha es nula, la seteamos al momento actual
        if (multa.getFechaGeneracion() == null) {
            multa.setFechaGeneracion(LocalDateTime.now());
        }
        return repository.save(multa);
    }

    public void delete(Long id) {
        log.info("eliminando la multa seleccionada.");
        repository.deleteById(id);
    }
}