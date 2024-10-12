package com.lojaAPP.applicationAPI.Modules.Produtos.DTO;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public record EditarProdutoDTO(
        @NotNull
        Long id,
        @NotNull
        String nome,
        @NotNull
        float preco_original,
        @NotNull
        float preco_a_vista,
        @NotNull
        String descricao,
        @NotNull
        MultipartFile imagem
){}
