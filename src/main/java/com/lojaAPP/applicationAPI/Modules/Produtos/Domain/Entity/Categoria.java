package com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.NovaCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoriaId;

    @Column
    private String nomeCategoria;

    @OneToOne(fetch = FetchType.LAZY)
    private Produtos produto;

    public Categoria(NovaCategoriaDTO novaCategoriaDTO){
        this.nomeCategoria = novaCategoriaDTO.nomeCategoria();
    }

}
