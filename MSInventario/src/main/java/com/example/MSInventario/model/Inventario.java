package com.example.MSInventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del libro es obligatorio")
    private Long libroId;

    @NotBlank(message = "El código de barras o serie es obligatorio")
    @Column(unique = true)
    private String codigoSerie;

    @NotBlank(message = "El estado es obligatorio (Nuevo/Dañado/Baja)")
    private String estado;

    private String ubicacionPasillo;

    private LocalDateTime fechaRegistro;
}