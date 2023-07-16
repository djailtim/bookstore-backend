package com.d3lt4.bookstore.dtos;

import jakarta.validation.constraints.NotNull;

public class AuthenticationDTO {

    @NotNull(message = "O login é obrigatório.")
    private String login;

    @NotNull(message = "A senha é obrigatória.")
    private String password;

    public AuthenticationDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
