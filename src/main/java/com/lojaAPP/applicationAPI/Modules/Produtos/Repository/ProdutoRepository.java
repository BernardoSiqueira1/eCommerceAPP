package com.lojaAPP.applicationAPI.Modules.Produtos.Repository;

import com.lojaAPP.applicationAPI.Modules.Produtos.Domain.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

}
