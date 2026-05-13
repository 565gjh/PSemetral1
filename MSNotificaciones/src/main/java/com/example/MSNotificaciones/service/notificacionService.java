package com.example.MSNotificaciones.service;


import com.example.MSNotificaciones.model.Notificacion;
import com.example.MSNotificaciones.repository.notificacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
@Slf4j
public class notificacionService {

    @Autowired
    private notificacionRepository repository;

    public List<Notificacion> findAll() {
        log.info("Obteniendo lista de todas las notificaciones.");
        return repository.findAll();
    }

    public Notificacion findById(Long id) {
        log.info("buscando notificacion por id.");
        return repository.findById(id).orElse(null);
    }

    public Notificacion save(Notificacion notificacion) {
        log.info("Guardando y enviando notificación.");
        if (notificacion.getFechaEnvio() == null) {
            notificacion.setFechaEnvio(LocalDateTime.now());
        }
        return repository.save(notificacion);
    }

    public void delete(Long id) {
        log.info("eliminando la notificación seleccionada.");
        repository.deleteById(id);
    }
}