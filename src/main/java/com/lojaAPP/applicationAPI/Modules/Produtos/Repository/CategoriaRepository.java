package com.lojaAPP.applicationAPI.Modules.Produtos.Repository;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
