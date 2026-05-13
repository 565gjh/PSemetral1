package com.example.categoria.controller;

import com.example.categoria.model.Categoria;
import com.example.categoria.repository.CategoriaRepository;
import com.example.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        return service.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.findById(id)
                .map(existing -> {existing.setNombre(categoria.getNombre());
                    return ResponseEntity.ok(service.save(existing));
                }).orElse(ResponseEntity.notFound().build());

    }
}

