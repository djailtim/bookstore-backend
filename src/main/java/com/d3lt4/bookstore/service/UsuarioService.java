package com.d3lt4.bookstore.service;

import com.d3lt4.bookstore.domain.Usuario;
import com.d3lt4.bookstore.domain.UsuarioRole;
import com.d3lt4.bookstore.dtos.RegisterDTO;
import com.d3lt4.bookstore.repositories.UsuarioRepository;
import com.d3lt4.bookstore.service.exceptions.ObjectExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario register(RegisterDTO data) {
        if (this.repository.findByLogin(data.getLogin()) != null) {
            throw new ObjectExistenteException("Login { " + data.getLogin() + " } já existente.");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        Usuario novoUsuario = new Usuario(data.getLogin(), encryptedPassword, UsuarioRole.USUARIO);

        return repository.save(novoUsuario);
    }
}
