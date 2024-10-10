package com.lojaAPP.applicationAPI.Modules.Produtos.DTO;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import jakarta.persistence.*;

public record NovaCategoriaDTO(
        String nomeCategoria
)
{}
