package com.example.MSLibro.controller;


import com.example.MSLibro.model.Libro;
import com.example.MSLibro.service.libroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class libroController {

    @Autowired
    private libroService service;

    @GetMapping
    public List<Libro> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> findById(@PathVariable Long id) {
        Libro libro = service.findById(id);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    // Endpoint específico para buscar por ISBN (Requisito del proyecto)
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Libro> findByIsbn(@PathVariable String isbn) {
        Libro libro = service.findByIsbn(isbn);
        return libro != null ? ResponseEntity.ok(libro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Libro> save(@Valid @RequestBody Libro libro) {
        return new ResponseEntity<>(service.save(libro), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}