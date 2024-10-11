package com.lojaAPP.applicationAPI.Utils;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.DetalhesProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;

import java.util.List;

public class ProdutosMapper {

    public List<DetalhesProdutoDTO> toDetalhesProdutoDTO(List<Produtos> produtos){
        return produtos.stream().map((produto) ->
                new DetalhesProdutoDTO (
                        produto.getProdutoId(),
                        produto.getNome(),
                        produto.getPreco_original(),
                        produto.getPreco_a_vista(),
                        produto.getDescricao(),
                        produto.getFoto_url(),
                        produto.getCategoriaProduto()
                )).toList();
    }

}
