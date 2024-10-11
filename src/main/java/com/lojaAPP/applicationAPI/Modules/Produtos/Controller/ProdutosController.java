package com.lojaAPP.applicationAPI.Modules.Produtos.Controller;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.EditarProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovaCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovoProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Services.ProdutosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosController implements ProdutosControllerDoc {

    @Autowired
    ProdutosService produtosService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrarProduto(@ModelAttribute @Valid NovoProdutoDTO novoProdutoDTO){
        produtosService.cadastrarProduto(novoProdutoDTO);
        return ResponseEntity.status(201).body("Produto cadastrado com sucesso.");
    }

    //TODO - melhorar os métodos depois, talvez posso construir de forma dinâmica uma query com EntityManager.
    @GetMapping(value = "buscar/categoria/{categoriaID")
    public ResponseEntity<?> buscarProdutos(@PathVariable long categoriaID) {
        var response = produtosService.buscarProdutoCategoria(categoriaID);

        return ResponseEntity.status(200).body(response);
    }

    @GetMapping(value = "buscar/{nomeProduto}")
    public ResponseEntity<?> buscarProdutos(@PathVariable(required = false) String nomeProduto){

        if(nomeProduto.isEmpty()){
            var response = produtosService.buscarTodosProdutos();
            return ResponseEntity.status(200).body(response);
        }

        else {
            var response = produtosService.buscarProduto(nomeProduto);
            return ResponseEntity.status(200).body(response);
        }

    }

    @PutMapping(value = "/editar")
    public ResponseEntity<?> editarProduto(@RequestBody EditarProdutoDTO editarProdutoDTO){
        produtosService.editarProduto(editarProdutoDTO);
        return ResponseEntity.status(200).body("Produto foi alterado.");
    }

    @DeleteMapping(value = "/excluir/{produtoID}")
    public ResponseEntity<?> excluirProduto(@PathVariable long produtoID){
        produtosService.excluirProduto(produtoID);
        return ResponseEntity.status(200).body("Produto excluído");
    }


    @PostMapping(value = "/categoria/cadastrar")
    public ResponseEntity<?> cadastrarCategoria(@RequestBody @Valid NovaCategoriaDTO novaCategoriaDTO){
        produtosService.cadastrarCategoria(novaCategoriaDTO);
        return ResponseEntity.status(201).body("Categoria cadastrada com sucesso.");
    }

    @GetMapping(value = "/categoria/buscar")
    public ResponseEntity<?> buscarCategorias(){
        var response = produtosService.buscarTodasCategorias();
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/categoria/excluir/categoriaID")
    public ResponseEntity<?> excluirCategoria(@PathVariable long categoriaID){
        produtosService.excluirCategoria(categoriaID);
        return ResponseEntity.status(200).body("Categoria excluída.");
    }
}
