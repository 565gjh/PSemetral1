package com.example.MSPrestamo.controller;

import com.example.MSPrestamo.model.Prestamo;
import com.example.MSPrestamo.service.prestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class prestamoController {

    @Autowired
    private prestamoService service;

    @GetMapping
    public List<Prestamo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> findById(@PathVariable Long id) {
        Prestamo prestamo = service.findById(id);
        return prestamo != null ? ResponseEntity.ok(prestamo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Prestamo> save(@Valid @RequestBody Prestamo prestamo) {
        return new ResponseEntity<>(service.save(prestamo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}