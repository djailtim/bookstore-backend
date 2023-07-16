package com.d3lt4.bookstore.resources;

import com.d3lt4.bookstore.config.security.TokenService;
import com.d3lt4.bookstore.domain.Usuario;
import com.d3lt4.bookstore.dtos.AuthenticationDTO;
import com.d3lt4.bookstore.dtos.RegisterDTO;
import com.d3lt4.bookstore.dtos.TokenResponseDTO;
import com.d3lt4.bookstore.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class AuthenticationResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService service;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@Valid @RequestBody AuthenticationDTO data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                data.getLogin(),
                data.getPassword()
        );

        Authentication auth = this.authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok().body(new TokenResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@Valid @RequestBody RegisterDTO data) {
        Usuario novoUsuario = service.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
