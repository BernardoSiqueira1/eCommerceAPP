package com.lojaAPP.applicationAPI.Modules.Pedidos.Controller;

import com.lojaAPP.applicationAPI.Modules.Pedidos.DTO.NovoPedidoDTO;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Enum.StatusPedido;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Services.PedidosService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidosService pedidosService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarPedido(@RequestBody NovoPedidoDTO novoPedidoDTO){
        pedidosService.criarPedido(novoPedidoDTO);
        return ResponseEntity.status(201).body("Pedido realizado com sucesso.");
    }

    @PreAuthorize("hasAuthority('ADMIN'")
    @GetMapping("/buscar/todos")
    public ResponseEntity<?> buscarPedidos(@RequestParam int pagina){
        var response = pedidosService.listarPedidos(pagina);
        return ResponseEntity.status(200).body(response);
    }

    @PreAuthorize("hasAuthority('ADMIN'")
    @GetMapping("/buscar/usuario")
    public ResponseEntity<?> buscarPedidosPorUsuario(@RequestParam long idUsuario, @RequestParam int pagina){
        var response = pedidosService.listarPedidosPorUsuario(idUsuario, pagina);
        return ResponseEntity.status(200).body(response);
    }

    @PreAuthorize("hasAuthority('ADMIN'")
    @PutMapping("/editar")
    public ResponseEntity<?> editarStatus(@RequestParam long idPedido, @RequestParam StatusPedido statusPedido){
        pedidosService.editarStatusPedido(idPedido, statusPedido);
        return ResponseEntity.status(200).body("Status do pedido foi alterado.");
    }

    @PreAuthorize("hasAuthority('ADMIN'")
    @DeleteMapping("/excluir")
    public ResponseEntity<?> excluirPedido(@RequestParam long idPedido){
        pedidosService.excluirPedido(idPedido);
        return ResponseEntity.status(200).body("Pedido foi excluído com sucesso.");
    }


}
