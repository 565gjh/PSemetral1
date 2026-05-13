package com.example.MSNotificaciones.repository;

import com.example.MSNotificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface notificacionRepository extends JpaRepository<Notificacion, Long> {
    // Para ver el historial de alertas de un usuario
    List<Notificacion> findByUsuarioId(Long usuarioId);
}