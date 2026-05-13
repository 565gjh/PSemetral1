package com.example.MSReservas.repository;

import com.example.MSReservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface reservaRepository extends JpaRepository<Reserva, Long> {
    // Para ver las reservas activas de un libro específico
    List<Reserva> findByLibroIdAndEstado(Long libroId, String estado);

    // Para ver las reservas de un usuario
    List<Reserva> findByUsuarioId(Long usuarioId);
}