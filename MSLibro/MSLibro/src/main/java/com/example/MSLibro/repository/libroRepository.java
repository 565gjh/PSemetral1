package com.example.MSLibro.repository;


import com.example.MSLibro.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface libroRepository extends JpaRepository<Libro, Long> {
    // Método adicional para cumplir con el requisito de búsqueda por ISBN
    Optional<Libro> findByIsbn(String isbn);
}