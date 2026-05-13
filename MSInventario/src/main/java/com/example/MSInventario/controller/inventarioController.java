package com.example.MSInventario.controller;

import com.example.MSInventario.model.Inventario;
import com.example.MSInventario.service.inventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class inventarioController {

    @Autowired
    private inventarioService service;

    @GetMapping
    public List<Inventario> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> findById(@PathVariable Long id) {
        Inventario inventario = service.findById(id);
        return inventario != null ? ResponseEntity.ok(inventario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Inventario> save(@Valid @RequestBody Inventario inventario) {
        return new ResponseEntity<>(service.save(inventario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}