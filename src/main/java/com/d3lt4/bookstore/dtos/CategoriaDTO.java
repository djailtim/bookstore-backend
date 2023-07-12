package com.d3lt4.bookstore.dtos;

import com.d3lt4.bookstore.domain.Categoria;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O nome da categoria é obrigatório.")
    @Length(min = 3, max = 100, message = "O nome da categoria entre 3 e 100 caracteres.")
    private String nome;

    @NotNull(message = "A descrição da categoria é obrigatório.")
    @Length(min = 3, max = 200, message = "A descrição da categoria entre 3 e 200 caracteres.")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
