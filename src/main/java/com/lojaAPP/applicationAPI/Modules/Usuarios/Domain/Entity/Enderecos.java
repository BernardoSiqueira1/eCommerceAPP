package com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity;

import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoEnderecoDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Enderecos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String estado;

    @Column
    private String cidade;

    @Column
    private String cep;

    @Column
    private String rua;

    @Column
    private String bairro;

    @Column
    private String numero;

    @ManyToOne
    private Usuario usuario;

    public Enderecos(NovoUsuarioDTO novoUsuarioDTO, Usuario usuario){
        this.estado = novoUsuarioDTO.estado();
        this.cidade = novoUsuarioDTO.cidade();
        this.cep = novoUsuarioDTO.cep();
        this.rua = novoUsuarioDTO.rua();
        this.bairro = novoUsuarioDTO.bairro();
        this.numero = novoUsuarioDTO.numero();
        this.usuario = usuario;
    }

    public Enderecos(NovoEnderecoDTO novoEnderecoDTO, Usuario usuario){
        this.estado = novoEnderecoDTO.estado();
        this.cidade = novoEnderecoDTO.cidade();
        this.cep = novoEnderecoDTO.cep();
        this.rua = novoEnderecoDTO.rua();
        this.bairro = novoEnderecoDTO.bairro();
        this.numero = novoEnderecoDTO.numero();
        this.usuario = usuario;
    }
}
