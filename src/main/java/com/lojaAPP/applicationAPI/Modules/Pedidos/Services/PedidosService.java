package com.lojaAPP.applicationAPI.Modules.Pedidos.Services;

import com.lojaAPP.applicationAPI.Modules.Pedidos.DTO.DetalhesPedidoDTO;
import com.lojaAPP.applicationAPI.Modules.Pedidos.DTO.NovoPedidoDTO;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Domain.Pedidos;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Enum.StatusPedido;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Repository.PedidosRepository;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import com.lojaAPP.applicationAPI.Modules.Produtos.Repository.ProdutoRepository;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Repository.UsuarioRepository;
import com.lojaAPP.applicationAPI.Utils.PedidosMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class PedidosService {

    @Autowired
    PedidosRepository pedidosRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidosMapper pedidosMapper;

    @Transactional
    public void criarPedido(NovoPedidoDTO novoPedidoDTO) {
        Usuario usuarioPedido = usuarioRepository.findById(novoPedidoDTO.usuarioPedido()).orElseThrow(() -> new EntityNotFoundException());

        List<Produtos> produtosPedido = novoPedidoDTO
                .produtosPedido()
                .stream()
                .map((id -> produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException())))
                .toList();

        Pedidos novoPedido = new Pedidos(usuarioPedido, produtosPedido);

        //Adicionando a relação no lado do produto também.
        for (Produtos produto : produtosPedido) {
            produto.getPedidos().add(novoPedido);
        }

        pedidosRepository.save(novoPedido);
    }

    public void editarStatusPedido(long idPedido, StatusPedido statusPedido) {
        Pedidos pedidosQuery = pedidosRepository.findById(idPedido).orElseThrow(() -> new EntityNotFoundException());
        pedidosQuery.setStatusPedido(statusPedido);
        pedidosRepository.save(pedidosQuery);
    }

    public List<DetalhesPedidoDTO> listarPedidos(int pagina){
        PageRequest pageRequest  = PageRequest.of(pagina, 10);

        Page<Pedidos> pedidosQuery = pedidosRepository.findAll(pageRequest);
        List<DetalhesPedidoDTO> detalhesPedidos = pedidosMapper.toDetalhesPedidoDTO(pedidosQuery);

        return detalhesPedidos;
    }

    public List<DetalhesPedidoDTO> listarPedidosPorUsuario(long idUsuario, int pagina){
        PageRequest pageRequest = PageRequest.of(pagina, 10);

        Page<Pedidos> pedidosQuery = pedidosRepository.findByUsuarioId(idUsuario, pageRequest);
        List<DetalhesPedidoDTO> detalhesPedidos = pedidosMapper.toDetalhesPedidoDTO(pedidosQuery);

        return detalhesPedidos;
    }

    public void excluirPedido(long idPedido){
        pedidosRepository.deleteById(idPedido);
    }

    public List<Pedidos> listarPedidosDebug() {
        return pedidosRepository.findAll();
    }
}
