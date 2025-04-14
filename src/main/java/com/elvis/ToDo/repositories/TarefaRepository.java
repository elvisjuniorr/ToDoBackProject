package com.elvis.ToDo.repositories;

import com.elvis.ToDo.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository <Tarefa, UUID> {

    public List<Tarefa> findAllByCategoriaId(UUID id_categoria);

}
