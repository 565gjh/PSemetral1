package com.example.MSReservas.controller;

import com.example.MSReservas.model.Reserva;
import com.example.MSReservas.service.reservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class reservaController {

    @Autowired
    private reservaService service;

    @GetMapping
    public List<Reserva> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id) {
        Reserva reserva = service.findById(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Reserva> save(@Valid @RequestBody Reserva reserva) {
        return new ResponseEntity<>(service.save(reserva), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}