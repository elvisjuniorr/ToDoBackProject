package com.elvis.ToDo.controllers;

import com.elvis.ToDo.dtos.CategoriaRecordDto;
import com.elvis.ToDo.models.Categoria;
import com.elvis.ToDo.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> saveCategorias(@RequestBody CategoriaRecordDto categoriaRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.saveCategoria(categoriaRecordDto));
    }

    @GetMapping("/{id_usuario}")
    public List<Categoria> findCategorias (@PathVariable UUID id_usuario){
        return categoriaService.findCategorias(id_usuario);
    }

    @DeleteMapping("/{id_categoria}")
    public void deleteCategoria (@PathVariable UUID id_categoria){
        categoriaService.deleteCategoria(id_categoria);
    }
}
