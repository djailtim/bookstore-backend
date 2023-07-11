package com.d3lt4.bookstore.service;

import com.d3lt4.bookstore.domain.Categoria;
import com.d3lt4.bookstore.domain.Livro;
import com.d3lt4.bookstore.repositories.LivroRepository;
import com.d3lt4.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Object not found, id: " + id + ". Tipo: " + Livro.class.getName()
        ));
    }

    public List<Livro> findAll(Integer id_categoria) {
        categoriaService.findById(id_categoria);
        return repository.findAllByCategoria(id_categoria);
    }
}
