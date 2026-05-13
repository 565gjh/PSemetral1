package com.example.MSReservas.service;


import com.example.MSReservas.model.Reserva;
import com.example.MSReservas.repository.reservaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
@Slf4j
public class reservaService {

    @Autowired
    private reservaRepository repository;

    public List<Reserva> findAll() {
        log.info("Obteniendo lista de todas las reservas.");
        return repository.findAll();
    }

    public Reserva findById(Long id) {
        log.info("buscando reserva por id.");
        return repository.findById(id).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        log.info("Guardando nueva reserva en el sistema.");
        if (reserva.getFechaReserva() == null) {
            reserva.setFechaReserva(LocalDateTime.now());
        }
        return repository.save(reserva);
    }

    public void delete(Long id) {
        log.info("eliminando la reserva seleccionada.");
        repository.deleteById(id);
    }
}