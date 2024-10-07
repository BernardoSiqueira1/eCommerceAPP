package com.lojaAPP.applicationAPI.Modules.Usuarios.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record NovoUsuarioDTO(
        @NotNull(message = "Email não pode ser nulo")
        String email,
        @NotNull(message = "Senha não pode ser nulo")
        String senha,
        @NotNull(message = "Nome não pode ser nulo")
        String nome,
        @NotNull(message = "CPF não pode ser nulo")
        String cpf,
        @NotNull(message = "Estado não pode ser nulo")
        String estado,
        @NotNull(message = "Cidade não pode ser nulo")
        String cidade,
        @NotNull(message = "Cep não pode ser nulo")
        String cep,
        @NotNull(message = "Rua não pode ser nulo")
        String rua,
        @NotNull(message = "Bairro não pode ser nulo")
        String bairro,
        @NotNull(message = "Numero não pode ser nulo")
        String numero
)
{}
