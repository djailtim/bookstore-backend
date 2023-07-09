package com.d3lt4.bookstore.resources;

import com.d3lt4.bookstore.domain.Categoria;
import com.d3lt4.bookstore.dtos.CategoriaDTO;
import com.d3lt4.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> categorias = service.findAll();
        List<CategoriaDTO> categoriasDTO = categorias.stream().map(CategoriaDTO::new).toList();
        return ResponseEntity.ok().body(categoriasDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> create (@RequestBody Categoria request) {
        request = service.create(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update (@PathVariable Integer id, @RequestBody CategoriaDTO request) {
        Categoria newCategoria = service.update(id, request);
        return ResponseEntity.ok().body(new CategoriaDTO(newCategoria));
    }
}
