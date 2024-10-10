package com.lojaAPP.applicationAPI.Modules.Produtos.DTO;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record NovoProdutoDTO(
        @NotNull
        String nome,
        @NotNull
        float preco_original,
        @NotNull
        float preco_a_vista,
        @NotNull
        String descricao,
        @NotNull
        MultipartFile imagem,
        @NotNull
        long categoriaId
)
{}
