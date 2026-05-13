package com.example.MSReportes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "reportes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El tipo de reporte es obligatorio (Uso/Actividad/Stock)")
    private String tipoReporte;

    @NotBlank(message = "El contenido del reporte es obligatorio")
    @Column(columnDefinition = "TEXT") // Para guardar JSON o textos largos
    private String datosJson;

    @NotBlank(message = "El autor del reporte es obligatorio")
    private String generadoPor;

    private LocalDateTime fechaCreacion;
}