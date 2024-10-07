package com.lojaAPP.applicationAPI.Modules.Usuarios.DTO;

import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity.Enderecos;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetalhesUsuarioDTO(
        String email,
        String nome,
        String cpf,
        List<DetalhesEnderecoDTO> enderecos
) {}

