package com.lojaAPP.applicationAPI.Modules.Pedidos.DTO;

import com.lojaAPP.applicationAPI.Modules.Pedidos.Enum.StatusPedido;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.DetalhesProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;

import java.util.List;

public record DetalhesPedidoDTO (
        long idPedido,
        List<DetalhesProdutoDTO> produtos,
        StatusPedido statusPedido
)
{}
