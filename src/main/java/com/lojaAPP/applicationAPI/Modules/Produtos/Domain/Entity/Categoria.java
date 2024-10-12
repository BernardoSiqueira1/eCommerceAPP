package com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovaCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoriaId;

    @Column(unique = true)
    private String nomeCategoria;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Produtos> produto;

    public Categoria(NovaCategoriaDTO novaCategoriaDTO){
        this.nomeCategoria = novaCategoriaDTO.nomeCategoria();
    }

}
