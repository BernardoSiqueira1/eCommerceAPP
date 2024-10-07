package com.lojaAPP.applicationAPI.Modules.Usuarios.DTO;

import jakarta.validation.constraints.NotNull;

public record DetalhesEnderecoDTO(
        String estado,
        String cidade,
        String cep,
        String rua,
        String bairro,
        String numero
)
{}
