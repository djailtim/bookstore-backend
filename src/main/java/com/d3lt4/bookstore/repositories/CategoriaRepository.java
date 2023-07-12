package com.d3lt4.bookstore.repositories;

import com.d3lt4.bookstore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Query("SELECT obj FROM Categoria obj WHERE obj.nome = :nome")
    Optional<Categoria> findByNome(String nome);

    boolean existsByNome(String nome);
}
