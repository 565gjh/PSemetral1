package com.example.MSInventario.service;

import com.example.MSInventario.model.Inventario;
import com.example.MSInventario.repository.inventarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
@Slf4j
public class inventarioService {

    @Autowired
    private inventarioRepository repository;

    public List<Inventario> findAll() {
        log.info("Obteniendo lista de todo el inventario físico.");
        return repository.findAll();
    }

    public Inventario findById(Long id) {
        log.info("buscando item de inventario por id.");
        return repository.findById(id).orElse(null);
    }

    public Inventario save(Inventario inventario) {
        log.info("Registrando ingreso/cambio en inventario.");
        if (inventario.getFechaRegistro() == null) {
            inventario.setFechaRegistro(LocalDateTime.now());
        }
        return repository.save(inventario);
    }

    public void delete(Long id) {
        log.info("eliminando registro de inventario.");
        repository.deleteById(id);
    }
}