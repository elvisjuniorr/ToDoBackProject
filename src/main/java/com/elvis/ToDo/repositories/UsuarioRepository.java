package com.elvis.ToDo.repositories;

import com.elvis.ToDo.models.Tarefa;
import com.elvis.ToDo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository <Usuario, UUID> {

    public Usuario findByEmail (String email);

}
