package com.d3lt4.bookstore.service;

import com.d3lt4.bookstore.domain.Categoria;
import com.d3lt4.bookstore.domain.Livro;
import com.d3lt4.bookstore.repositories.LivroRepository;
import com.d3lt4.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public Livro findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Object not found, id: " + id + ". Tipo: " + Livro.class.getName()
        ));
    }
}
