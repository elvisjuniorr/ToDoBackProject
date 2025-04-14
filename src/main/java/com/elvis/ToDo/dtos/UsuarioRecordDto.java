package com.elvis.ToDo.dtos;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public record UsuarioRecordDto(String nome,
                               String sobrenome,
                               String email,
                               String senha,
                               Date data_criacao,
                               Set<UUID> categorias){

}
