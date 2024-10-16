package com.lojaAPP.applicationAPI.Utils;

import com.lojaAPP.applicationAPI.Modules.Pedidos.DTO.DetalhesPedidoDTO;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Domain.Pedidos;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidosMapper {

    @Autowired
    ProdutosMapper produtosMapper;

    public List<DetalhesPedidoDTO> toDetalhesPedidoDTO(Page<Pedidos> pagePedidos) {
        List<Pedidos> pedidosList = pagePedidos.stream().toList();

        List<DetalhesPedidoDTO> detalhesPedidoList = pedidosList
                .stream()
                .map(pedido -> new DetalhesPedidoDTO(
                        pedido.getUsuarioPedido().getCpf(),
                        pedido.getUsuarioPedido().getNome(),
                        pedido.getUsuarioPedido().getTelefone(),
                        pedido.getProdutosPedido().stream().map(produtosMapper::toDetalhesProdutoDTO).toList(),
                        pedido.getStatusPedido()
                ))
                .toList();

        return detalhesPedidoList;
    }
}
