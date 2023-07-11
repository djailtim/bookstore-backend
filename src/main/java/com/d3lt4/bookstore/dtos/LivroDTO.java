package com.d3lt4.bookstore.dtos;

import com.d3lt4.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
