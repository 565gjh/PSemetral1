package com.example.MSMultas.repository;


import com.example.MSMultas.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface multaRepository extends JpaRepository<Multa, Long> {
    // Para buscar las multas de un usuario específico
    List<Multa> findByUsuarioId(Long usuarioId);
}
