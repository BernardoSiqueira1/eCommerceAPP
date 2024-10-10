package com.lojaAPP.applicationAPI.Modules.Produtos.Controller;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovaCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovoProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Services.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController implements ProdutosControllerDoc {
    @Autowired
    ProdutosService produtosService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrarProduto(@ModelAttribute NovoProdutoDTO novoProdutoDTO){
        produtosService.cadastrarProduto(novoProdutoDTO);
        return ResponseEntity.status(201).body("Produto cadastrado com sucesso.");
    }

    @PostMapping(value = "/cadastrarCategoria")
    public ResponseEntity<?> cadastrarCategoria(@RequestBody NovaCategoriaDTO novaCategoriaDTO){
        produtosService.cadastrarCategoria(novaCategoriaDTO);
        return ResponseEntity.status(201).body("Categoria cadastrada com sucesso.");
    }
}
