package com.d3lt4.bookstore.resources;

import com.d3lt4.bookstore.domain.Livro;
import com.d3lt4.bookstore.dtos.LivroDTO;
import com.d3lt4.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById (@PathVariable Integer id) {
        Livro livro = service.findById(id);
        return ResponseEntity.ok().body(livro);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_categoria) {
        List<Livro> listLivros = service.findAll(id_categoria);
        List<LivroDTO> listLivrosDTO = listLivros.stream().map(LivroDTO::new).toList();
        return ResponseEntity.ok().body(listLivrosDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro) {
        Livro novoLivro = service.update(id, livro);
        return ResponseEntity.ok().body(novoLivro);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro livro) {
        Livro novoLivro = service.update(id, livro);
        return ResponseEntity.ok().body(novoLivro);
    }
}
