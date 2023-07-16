package com.d3lt4.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    @JsonIgnore
    private String password;

    @JsonIgnore
    private UsuarioRole role;

    public Usuario() {
        super();
    }

    public Usuario(String login, String password, UsuarioRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Usuario(Integer id, String login, String password, UsuarioRole role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRole getRole() {
        return role;
    }

    public void setRole(UsuarioRole role) {
        this.role = role;
    }

    @JsonIgnore

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return login;
    }
    @JsonIgnore

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @JsonIgnore

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @JsonIgnore

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @JsonIgnore

    @Override
    public boolean isEnabled() {
        return true;
    }
}
