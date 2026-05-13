package com.example.MSInventario.repository;


import com.example.MSInventario.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface inventarioRepository extends JpaRepository<Inventario, Long> {
    // Para ver todos los ejemplares físicos de un mismo título
    List<Inventario> findByLibroId(Long libroId);

    // Para buscar por su código único
    Inventario findByCodigoSerie(String codigoSerie);
}