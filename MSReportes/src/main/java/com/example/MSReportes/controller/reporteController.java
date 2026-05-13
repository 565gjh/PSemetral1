package com.example.MSReportes.controller;


import com.example.MSReportes.model.Reporte;
import com.example.MSReportes.service.reporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class reporteController {

    @Autowired
    private reporteService service;

    @GetMapping
    public List<Reporte> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> findById(@PathVariable Long id) {
        Reporte reporte = service.findById(id);
        return reporte != null ? ResponseEntity.ok(reporte) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Reporte> save(@Valid @RequestBody Reporte reporte) {
        return new ResponseEntity<>(service.save(reporte), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}