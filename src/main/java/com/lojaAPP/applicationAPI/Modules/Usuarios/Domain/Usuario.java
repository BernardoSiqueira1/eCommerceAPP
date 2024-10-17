package com.lojaAPP.applicationAPI.Modules.Usuarios.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lojaAPP.applicationAPI.Modules.Pedidos.Domain.Pedidos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity.Enderecos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Enum.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;

    @Column
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String telefone;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "usuario")
    private List<Enderecos> enderecosCliente;

    @OneToMany
    private List<Pedidos> pedidosCliente;

    public Usuario(NovoUsuarioDTO novoUsuarioDTO) {
        this.email = novoUsuarioDTO.email();
        this.nome = novoUsuarioDTO.nome();
        this.cpf = novoUsuarioDTO.cpf();
        this.senha = novoUsuarioDTO.senha();
        this.telefone = novoUsuarioDTO.telefone();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Roles.ADMIN){
            return List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("CLIENTE"));
        }
        else {
            return List.of(new SimpleGrantedAuthority("CLIENTE"));
        }
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
