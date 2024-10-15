package com.lojaAPP.applicationAPI.Modules.Produtos.Repository;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c ORDER BY c.categoriaId ASC")
    List<Categoria> findAllCategorias();
}
