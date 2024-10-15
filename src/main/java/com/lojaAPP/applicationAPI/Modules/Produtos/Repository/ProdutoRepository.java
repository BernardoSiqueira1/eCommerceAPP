package com.lojaAPP.applicationAPI.Modules.Produtos.Repository;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
    @Query("SELECT p FROM Produtos p WHERE p.nome LIKE %:nome%")
    List<Produtos> findByNameLike(@Param("nome") String nome);

    @Query("SELECT COUNT(p) FROM Produtos p WHERE p.categoriaProduto.categoriaId = :categoriaId")
    long countProdutosCategoria(@Param("categoriaId") long categoriaId);

    @Query("SELECT p FROM Produtos p WHERE p.categoriaProduto.categoriaId = :categoriaId")
    List<Produtos> findProdutoByCategoria(@Param("categoriaId") long categoriaId);
}
