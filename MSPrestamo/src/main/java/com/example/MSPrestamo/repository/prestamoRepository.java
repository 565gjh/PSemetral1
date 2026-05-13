package com.example.MSPrestamo.repository;


import com.example.MSPrestamo.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface prestamoRepository extends JpaRepository<Prestamo, Long> {
    // Método útil para ver los préstamos de un usuario específico
    List<Prestamo> findByUsuarioId(Long usuarioId);
}