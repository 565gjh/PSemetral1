package com.example.MSLibro.service;


import com.example.MSLibro.model.Libro;
import com.example.MSLibro.repository.libroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class libroService {

    @Autowired
    private libroRepository repository;

    public List<Libro> findAll() {
        log.info("Obteniendo lista de todos los libros.");
        return repository.findAll();
    }

    public Libro findById(Long id) {
        log.info("buscando libro por id.");
        // Usamos .orElse(null) para manejarlo en el controller como tus otros ejemplos
        return repository.findById(id).orElse(null);
    }

    public Libro findByIsbn(String isbn) {
        log.info("buscando libro por ISBN.");
        return repository.findByIsbn(isbn).orElse(null);
    }

    public Libro save(Libro libro) {
        log.info("Guardando el libro.");
        return repository.save(libro);
    }

    public void delete(Long id) {
        log.info("eliminando el libro seleccionado.");
        repository.deleteById(id);
    }
}