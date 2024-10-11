package com.lojaAPP.applicationAPI.Utils;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.DetalhesProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.EditarProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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

    public Produtos toProdutoEditado(Produtos produto, EditarProdutoDTO editarProdutoDTO, String imagemURL){
        produto.setNome(editarProdutoDTO.nome());
        produto.setPreco_original(editarProdutoDTO.preco_original());
        produto.setPreco_a_vista(editarProdutoDTO.preco_a_vista());
        produto.setDescricao(editarProdutoDTO.descricao());
        produto.setFoto_url(imagemURL);

        return produto;
    }

}
