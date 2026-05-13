package com.example.MSReportes.service;


import com.example.MSReportes.model.Reporte;
import com.example.MSReportes.repository.reporteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
@Slf4j
public class reporteService {

    @Autowired
    private reporteRepository repository;

    public List<Reporte> findAll() {
        log.info("Obteniendo lista de todos los reportes generados.");
        return repository.findAll();
    }

    public Reporte findById(Long id) {
        log.info("buscando reporte por id.");
        return repository.findById(id).orElse(null);
    }

    public Reporte save(Reporte reporte) {
        log.info("Generando nuevo reporte de sistema.");
        if (reporte.getFechaCreacion() == null) {
            reporte.setFechaCreacion(LocalDateTime.now());
        }
        return repository.save(reporte);
    }

    public void delete(Long id) {
        log.info("eliminando reporte del historial.");
        repository.deleteById(id);
    }
}