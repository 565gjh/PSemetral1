package com.example.MSAutores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "autores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del autor es obligatorio")
    private String nombre;

    @NotBlank(message = "La biografía es obligatoria")
    @Size(max = 1000, message = "La biografía no puede exceder los 1000 caracteres")
    private String biografia;
}