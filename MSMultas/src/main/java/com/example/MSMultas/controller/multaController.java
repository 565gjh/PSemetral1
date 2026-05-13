package com.example.MSMultas.controller;

import com.example.MSMultas.model.Multa;
import com.example.MSMultas.service.multaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/multas")
public class multaController {

    @Autowired
    private multaService service;

    @GetMapping
    public List<Multa> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Multa> findById(@PathVariable Long id) {
        Multa multa = service.findById(id);
        return multa != null ? ResponseEntity.ok(multa) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Multa> save(@Valid @RequestBody Multa multa) {
        return new ResponseEntity<>(service.save(multa), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
