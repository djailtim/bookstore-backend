package com.d3lt4.bookstore.service;

import com.d3lt4.bookstore.domain.Categoria;
import com.d3lt4.bookstore.dtos.CategoriaDTO;
import com.d3lt4.bookstore.repositories.CategoriaRepository;
import com.d3lt4.bookstore.service.exceptions.ObjectExistenteException;
import com.d3lt4.bookstore.service.exceptions.DataIntegrityViolationException;
import com.d3lt4.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Object not found, id: " + id + ". Tipo: " + Categoria.class.getName()
        ));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);
        boolean categoriaExistente = repository.existsByNome(categoria.getNome());
        if (categoriaExistente) {
            throw new ObjectExistenteException("Categoria { " + categoria.getNome() + " } já existente.");
        }
        return repository.save(categoria);
    }

    public Categoria update(Integer id, CategoriaDTO request) {
        Categoria categoria = findById(id);
        categoria.setNome(request.getNome());
        categoria.setDescricao(request.getDescricao());
        return repository.save(categoria);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException exception) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada. Tem livros associados!");
        }
    }
}
