package com.lojaAPP.applicationAPI.Utils;

import com.lojaAPP.applicationAPI.Modules.Produtos.DTO.DetalhesCategoriaDTO;
import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;

import java.util.List;

public class CategoriasMapper {

    public List<DetalhesCategoriaDTO> todetalhesCategoriaDTO(List<Categoria> categorias){
        return categorias.stream().map(categoria ->
                new DetalhesCategoriaDTO(categoria.getCategoriaId(),categoria.getNomeCategoria())
        ).toList();
    }
}
