package com.lojaAPP.applicationAPI.Modules.Usuarios.Domain;

import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity.Enderecos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Enum.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

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

    public Usuario(NovoUsuarioDTO novoUsuarioDTO){
        this.email = novoUsuarioDTO.email();
        this.nome = novoUsuarioDTO.nome();
        this.cpf = novoUsuarioDTO.cpf();
        this.senha = novoUsuarioDTO.senha();
        this.telefone = novoUsuarioDTO.telefone();
        this.role = role;
    }

}
