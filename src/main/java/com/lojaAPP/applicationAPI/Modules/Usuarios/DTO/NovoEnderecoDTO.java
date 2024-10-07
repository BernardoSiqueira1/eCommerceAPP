package com.lojaAPP.applicationAPI.Modules.Usuarios.DTO;

import jakarta.validation.constraints.NotNull;

public record NovoEnderecoDTO(
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
