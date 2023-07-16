package com.d3lt4.bookstore.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class RegisterDTO {

    @NotNull(message = "O login é obrigatório.")
    @Length(min = 3, max = 25, message = "O nome do autor deve ter entre 3 e 25 caracteres.")
    private String login;

    @NotNull(message = "O senha é obrigatória.")
    @Length(min = 6, max = 10, message = "O senha deve ter entre 6 e 10 caracteres.")
    private String password;

    public RegisterDTO(String login, String password) {
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
