package com.elvis.ToDo.controllers;

import com.elvis.ToDo.dtos.LogInDto;
import com.elvis.ToDo.dtos.UsuarioRecordDto;
import com.elvis.ToDo.models.Tarefa;
import com.elvis.ToDo.models.Usuario;
import com.elvis.ToDo.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario (@RequestBody UsuarioRecordDto usuarioRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuarioRecordDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(@RequestBody LogInDto logInDto) {
        try {
            Usuario usuario = usuarioService.autenticarUsuario(logInDto.email(), logInDto.senha());
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/email/{email}")
    public Usuario findUsuarioByEmail(@PathVariable String email) {
        return usuarioService.findUsuarioByEmail(email);
    }
}
