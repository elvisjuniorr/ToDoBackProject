package com.elvis.ToDo.repositories;

import com.elvis.ToDo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository <Categoria, UUID> {

    List<Categoria> findAllByUsuarioId(UUID id_usuario);

}
