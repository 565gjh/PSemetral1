package com.example.MSAutores.service;

import com.example.MSAutores.model.Autor;
import com.example.MSAutores.repository.autorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class autorService {

    @Autowired
    private autorRepository repository;

    public List<Autor> findAll() {
        log.info("Obteniendo lista de todos los autores.");
        return repository.findAll();
    }

    public Autor findById(Long id) {
        log.info("buscando autor por id.");
        return repository.findById(id).orElse(null);
    }

    public Autor save(Autor autor) {
        log.info("Guardando el autor.");
        return repository.save(autor);
    }

    public void delete(Long id) {
        log.info("eliminando al autor seleccionado.");
        repository.deleteById(id);
    }
}