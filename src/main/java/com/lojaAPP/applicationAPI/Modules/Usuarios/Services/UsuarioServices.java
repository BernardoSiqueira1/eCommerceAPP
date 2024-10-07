package com.lojaAPP.applicationAPI.Modules.Usuarios.Services;

import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.DetalhesUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoEnderecoDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Entity.Enderecos;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Domain.Usuario;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Enum.Roles;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Repository.EnderecosRepository;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Repository.UsuarioRepository;
import com.lojaAPP.applicationAPI.Utils.UsuarioMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

    @Transactional
    public void cadastrarCliente(NovoUsuarioDTO novoUsuarioDTO) {
        Usuario novoUsuario = new Usuario(novoUsuarioDTO);
        novoUsuario.setRole(Roles.CLIENTE);
        usuarioRepository.save(novoUsuario);

        Enderecos novoEndereco = new Enderecos(novoUsuarioDTO, novoUsuario);
        enderecosRepository.save(novoEndereco);
    }

    public DetalhesUsuarioDTO buscarUsuario(long userId){
        Usuario usuarioQuery = usuarioRepository.getUsuarioByUserId(userId).orElseThrow(EntityNotFoundException::new);

        DetalhesUsuarioDTO detalhesUsuario = usuarioMapper.toDetalhesUsuarioDTO(usuarioQuery);

        return detalhesUsuario;
    }

    public void excluirUsuario(long userId){
        usuarioRepository.deleteById(userId);
    }

    @Transactional
    public void cadastrarNovoEndereco(NovoEnderecoDTO novoEnderecoDTO, long userId){
        Usuario usuarioQuery = usuarioRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        Enderecos novoEndereco = new Enderecos(novoEnderecoDTO, usuarioQuery);
        enderecosRepository.save(novoEndereco);
    }

    public void excluirEndereco(long enderecoId){
        enderecosRepository.deleteById(enderecoId);
    }

}
