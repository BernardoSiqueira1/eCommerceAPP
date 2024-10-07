package com.lojaAPP.applicationAPI.Utils;

import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.DetalhesEnderecoDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.DetalhesUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity.Enderecos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    public DetalhesUsuarioDTO toDetalhesUsuarioDTO(Usuario usuario){
        List<DetalhesEnderecoDTO> enderecosUsuario =  usuario.getEnderecosCliente().stream().map(this::toDetalhesEnderecoDTO).toList();

        DetalhesUsuarioDTO detalhesUsuario = new DetalhesUsuarioDTO(
                usuario.getEmail(),
                usuario.getNome(),
                usuario.getCpf(),
                enderecosUsuario
        );

        return detalhesUsuario;
    }

    public DetalhesEnderecoDTO toDetalhesEnderecoDTO(Enderecos enderecos){

        DetalhesEnderecoDTO detalhesEndereco = new DetalhesEnderecoDTO(
                enderecos.getEstado(),
                enderecos.getCidade(),
                enderecos.getCep(),
                enderecos.getRua(),
                enderecos.getBairro(),
                enderecos.getNumero()
        );

        return detalhesEndereco;
    }
}
