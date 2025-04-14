package com.elvis.ToDo.dtos;

import java.util.Date;
import java.util.UUID;

public record TarefaRecordDto(String titulo_tarefa,
                              UUID id_categoria,
                              String descricao,
                              Date data_criacao,
                              Date data_conclusao,
                              Boolean conclusao){

}
