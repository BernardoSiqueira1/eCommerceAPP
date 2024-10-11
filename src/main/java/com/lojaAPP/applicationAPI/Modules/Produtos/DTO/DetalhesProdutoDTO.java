package com.lojaAPP.applicationAPI.Modules.Produtos.DTO;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;
import jakarta.persistence.*;

public record DetalhesProdutoDTO(
        long produtoId,
        String nome,
        float preco_original,
        float preco_a_vista, String descricao,
        String foto_url,
        Categoria categoria
)
{}
