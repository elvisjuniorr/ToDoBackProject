package com.elvis.ToDo.services;

import com.elvis.ToDo.dtos.TarefaRecordDto;
import com.elvis.ToDo.models.Tarefa;
import com.elvis.ToDo.repositories.CategoriaRepository;
import com.elvis.ToDo.repositories.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    private final CategoriaRepository listaRepository;

    public TarefaService(TarefaRepository tarefaRepository, CategoriaRepository categoriaRepository) {
        this.tarefaRepository = tarefaRepository;
        this.listaRepository = categoriaRepository;
    }


    @Transactional
    public Tarefa saveTarefa(TarefaRecordDto tarefaRecordDto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo_tarefa(tarefaRecordDto.titulo_tarefa());
        tarefa.setDescricao(tarefaRecordDto.descricao());
        tarefa.setData_criacao(new java.sql.Date(System.currentTimeMillis()));
        tarefa.setData_conclusao(null);
        tarefa.setConclusao(false);
        tarefa.setCategoria(listaRepository.findById(tarefaRecordDto.id_categoria()).get());

        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public Tarefa completeTarefa(UUID id_tarefa) {
        Tarefa tarefa = tarefaRepository.findById(id_tarefa)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id_tarefa));
        tarefa.setData_conclusao(new java.sql.Date(System.currentTimeMillis()));
        tarefa.setConclusao(true);

        return tarefaRepository.save(tarefa);
    }

    @Transactional
    public List<Tarefa> findTarefas (UUID id_categoria){
        return tarefaRepository.findAllByCategoriaId(id_categoria);
    }

    @Transactional
    public void deleteTarefa (UUID id_tarefa){
        tarefaRepository.deleteById(id_tarefa);
    }
}
