package com.lojaAPP.applicationAPI.Modules.Produtos.DTO;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public record NovaCategoriaDTO(
        @NotNull
        String nomeCategoria
)
{}
