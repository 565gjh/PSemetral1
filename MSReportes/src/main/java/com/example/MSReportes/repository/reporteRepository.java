package com.example.MSReportes.repository;


import com.example.MSReportes.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface reporteRepository extends JpaRepository<Reporte, Long> {
    // Buscar reportes por tipo (ej. todos los de 'Uso')
    List<Reporte> findByTipoReporte(String tipoReporte);
}