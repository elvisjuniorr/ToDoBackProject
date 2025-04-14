package com.elvis.ToDo.services;

import com.elvis.ToDo.dtos.CategoriaRecordDto;
import com.elvis.ToDo.models.Categoria;
import com.elvis.ToDo.repositories.CategoriaRepository;
import com.elvis.ToDo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final UsuarioRepository usuarioRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, UsuarioRepository usuarioRepository) {
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional
    public Categoria saveCategoria(CategoriaRecordDto categoriaRecordDto) {
        Categoria categoria = new Categoria();
        categoria.setTitulo_categoria(categoriaRecordDto.titulo_categoria());
        categoria.setData_criacao(new java.sql.Date(System.currentTimeMillis()));
        categoria.setUsuario(usuarioRepository.findById(categoriaRecordDto.id_usuario()).get());

        return categoriaRepository.save(categoria);
    }

    @Transactional
    public List<Categoria> findCategorias (UUID id_categoria){
        return categoriaRepository.findAllByUsuarioId(id_categoria);
    }

    @Transactional
    public void deleteCategoria (UUID id_categoria){
        categoriaRepository.deleteById(id_categoria);
    }
}
