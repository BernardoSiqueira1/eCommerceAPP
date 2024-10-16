package com.lojaAPP.applicationAPI.Modules.Pedidos.Controller;

import com.lojaAPP.applicationAPI.Modules.Pedidos.DTO.NovoPedidoDTO;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Enum.StatusPedido;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Services.PedidosService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/buscar/debug")
    public ResponseEntity<?> buscarPedidos(){
        var response = pedidosService.listarPedidosDebug();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<?> buscarPedidos(@RequestParam int pagina){
        var response = pedidosService.listarPedidos(pagina);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/buscar/usuario")
    public ResponseEntity<?> buscarPedidosPorUsuario(@RequestParam long idUsuario, @RequestParam int pagina){
        var response = pedidosService.listarPedidosPorUsuario(idUsuario, pagina);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarStatus(@RequestParam long idPedido, @RequestParam StatusPedido statusPedido){
        pedidosService.editarStatusPedido(idPedido, statusPedido);
        return ResponseEntity.status(200).body("Status do pedido foi alterado.");
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<?> excluirPedido(@RequestParam long idPedido){
        pedidosService.excluirPedido(idPedido);
        return ResponseEntity.status(200).body("Pedido foi excluído com sucesso.");
    }


}
