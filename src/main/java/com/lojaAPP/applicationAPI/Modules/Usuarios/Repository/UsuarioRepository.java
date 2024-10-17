package com.lojaAPP.applicationAPI.Modules.Usuarios.Repository;

import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> getUsuarioByEmail(String emailUsuario);
    Optional<Usuario> getUsuarioByUserId(long userId);
    void deleteByEmail(String emailUsuario);
    UserDetails findByEmail(String email);
}
