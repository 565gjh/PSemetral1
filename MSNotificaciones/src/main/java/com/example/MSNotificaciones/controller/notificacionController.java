package com.example.MSNotificaciones.controller;


import com.example.MSNotificaciones.model.Notificacion;
import com.example.MSNotificaciones.service.notificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class notificacionController {

    @Autowired
    private notificacionService service;

    @GetMapping
    public List<Notificacion> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> findById(@PathVariable Long id) {
        Notificacion notificacion = service.findById(id);
        return notificacion != null ? ResponseEntity.ok(notificacion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Notificacion> save(@Valid @RequestBody Notificacion notificacion) {
        return new ResponseEntity<>(service.save(notificacion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
