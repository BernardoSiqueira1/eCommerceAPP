package com.lojaAPP.applicationAPI.Modules.Pedidos.Repository;

import com.lojaAPP.applicationAPI.Modules.Pedidos.Domain.Pedidos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    @Query("SELECT p FROM Pedidos p WHERE p.usuarioPedido.userId = :usuarioId")
    Page<Pedidos> findByUsuarioId(@Param(value = "usuarioId") Long usuarioId, Pageable pageable);
}