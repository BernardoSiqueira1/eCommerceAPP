package com.lojaAPP.applicationAPI.Modules.Usuarios.Repository;

import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {
}
