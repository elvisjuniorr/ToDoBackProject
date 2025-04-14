package com.elvis.ToDo.services;

import com.elvis.ToDo.dtos.UsuarioRecordDto;
import com.elvis.ToDo.models.Usuario;
import com.elvis.ToDo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional
    public Usuario saveUsuario(UsuarioRecordDto usuarioRecordDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRecordDto.nome());
        usuario.setSobrenome(usuarioRecordDto.sobrenome());
        usuario.setEmail(usuarioRecordDto.email());
        usuario.setSenha(usuarioRecordDto.senha());
        usuario.setData_criacao(new java.sql.Date(System.currentTimeMillis()));

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario findUsuarioByEmail (String email){
        return usuarioRepository.findByEmail(email);
    }

    @Transactional
    public Usuario autenticarUsuario(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        throw new RuntimeException("Credenciais inválidas");
    }
}
