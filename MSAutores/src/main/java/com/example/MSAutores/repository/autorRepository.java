package com.example.MSAutores.repository;


import com.example.MSAutores.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface autorRepository extends JpaRepository<Autor, Long> {
}