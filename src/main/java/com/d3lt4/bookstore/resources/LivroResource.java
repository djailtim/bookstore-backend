package com.d3lt4.bookstore.resources;

import com.d3lt4.bookstore.domain.Livro;
import com.d3lt4.bookstore.dtos.LivroDTO;
import com.d3lt4.bookstore.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping()
    public ResponseEntity<Livro> create (@RequestParam(value = "id_categoria", defaultValue = "0") Integer id_categoria, @Valid @RequestBody Livro livro) {
        Livro novoLivro = service.create(id_categoria, livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
