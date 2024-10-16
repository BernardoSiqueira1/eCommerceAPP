package com.lojaAPP.applicationAPI.Modules.Pedidos.DTO;

import com.lojaAPP.applicationAPI.Modules.Pedidos.Enum.StatusPedido;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record NovoPedidoDTO(
        @NotNull
        long usuarioPedido,
        @NotNull
        List<Long> produtosPedido
)
{}
