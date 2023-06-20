package com.d3lt4.bookstore.service;

import com.d3lt4.bookstore.domain.Categoria;
import com.d3lt4.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    public Categoria findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
