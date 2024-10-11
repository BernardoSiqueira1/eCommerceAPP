package com.lojaAPP.applicationAPI.Modules.Produtos.Domain;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovoProdutoDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long produtoId;

    @Column(unique = true)
    private String nome;

    @Column
    private float preco_original;

    @Column
    private float preco_a_vista;

    @Column
    private String descricao;

    @Column
    private String foto_url;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaProduto;

    public Produtos(NovoProdutoDTO novoProdutoDTO, String imageURL, Categoria categoriaProduto) {
        this.nome = novoProdutoDTO.nome();
        this.preco_original = novoProdutoDTO.preco_original();
        this.preco_a_vista = novoProdutoDTO.preco_a_vista();
        this.descricao = novoProdutoDTO.descricao();
        this.foto_url = imageURL;
        this.categoriaProduto = categoriaProduto;
    }


}
