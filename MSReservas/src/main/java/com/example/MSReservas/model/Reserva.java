package com.example.MSReservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del libro es obligatorio")
    private Long libroId;

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long usuarioId;

    @NotNull(message = "La posición en la fila es obligatoria")
    @Min(value = 1, message = "La posición debe ser al menos 1")
    private Integer posicionFila;

    private LocalDateTime fechaReserva;

    @NotBlank(message = "El estado es obligatorio (ACTIVA/CANCELADA/COMPLETADA)")
    private String estado;
}
