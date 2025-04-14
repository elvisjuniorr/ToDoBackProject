package com.elvis.ToDo.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record CategoriaRecordDto(String titulo_categoria,
                                 Date data_criacao,
                                 UUID id_usuario,
                                 Set<UUID> tarefas){

}
