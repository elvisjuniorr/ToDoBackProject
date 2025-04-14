package com.elvis.ToDo.controllers;

import com.elvis.ToDo.dtos.TarefaRecordDto;
import com.elvis.ToDo.models.Tarefa;
import com.elvis.ToDo.services.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> saveTarefa (@RequestBody TarefaRecordDto tarefaRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.saveTarefa(tarefaRecordDto));
    }

    @GetMapping("/{id_categoria}")
    public List<Tarefa> findTarefas (@PathVariable UUID id_categoria) {
        return tarefaService.findTarefas(id_categoria);
    }

    @PutMapping("/concluir/{id_tarefa}")
    public ResponseEntity<Tarefa> completeTarefa(@PathVariable UUID id_tarefa) {
        return ResponseEntity.ok(tarefaService.completeTarefa(id_tarefa));
    }

    @DeleteMapping("/{id_tarefa}")
    public void deleteTarefa (@PathVariable UUID id_tarefa){
        tarefaService.deleteTarefa(id_tarefa);
    }
}
