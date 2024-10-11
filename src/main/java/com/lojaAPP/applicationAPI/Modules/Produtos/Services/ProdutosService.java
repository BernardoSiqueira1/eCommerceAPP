package com.lojaAPP.applicationAPI.Modules.Produtos.Services;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.DetalhesCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.DetalhesProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovaCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovoProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import com.lojaAPP.applicationAPI.Modules.Produtos.Repository.CategoriaRepository;
import com.lojaAPP.applicationAPI.Modules.Produtos.Repository.ProdutoRepository;
import com.lojaAPP.applicationAPI.Utils.CategoriasMapper;
import com.lojaAPP.applicationAPI.Utils.ProcessaImagem;
import com.lojaAPP.applicationAPI.Utils.ProdutosMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProcessaImagem processaImagem;

    @Autowired
    private ProdutosMapper produtosMapper;

    @Autowired
    private CategoriasMapper categoriasMapper;

    @Transactional
    public void cadastrarProduto(NovoProdutoDTO novoProdutoDTO){
        String imagemURL = processaImagem.salvarImagem(novoProdutoDTO.imagem());

        Categoria categoriaProduto = categoriaRepository.findById(novoProdutoDTO.categoriaId()).orElseThrow(EntityNotFoundException::new);

        Produtos novoProduto = new Produtos(novoProdutoDTO, imagemURL, categoriaProduto);

        produtoRepository.save(novoProduto);
    }

    @Transactional
    public void editarProduto(long produtoId){

    }

    public List<DetalhesProdutoDTO> buscarProduto(String nome){
        return produtosMapper.toDetalhesProdutoDTO(produtoRepository.findByNameLike(nome));
    }

    public List<DetalhesProdutoDTO> buscarTodosProdutos(){
        return produtosMapper.toDetalhesProdutoDTO(produtoRepository.findAll());
    }


    @Transactional
    public void excluirProduto(long produtoId){
        produtoRepository.deleteById(produtoId);
    }

    @Transactional
    public void cadastrarCategoria(NovaCategoriaDTO novaCategoriaDTO){
        Categoria novaCategoria = new Categoria(novaCategoriaDTO);

        categoriaRepository.save(novaCategoria);
    }

    public List<DetalhesCategoriaDTO> buscarTodasCategorias(){
        return categoriasMapper.todetalhesCategoriaDTO(categoriaRepository.findAll());
    }

    public void excluirCategoria(long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

}
