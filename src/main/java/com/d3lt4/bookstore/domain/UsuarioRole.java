package com.d3lt4.bookstore.domain;

public enum UsuarioRole {
    USUARIO("usuario");

    private String role;

    UsuarioRole(String role) {
    }

    public String getRole() {
        return  role;
    }
}
