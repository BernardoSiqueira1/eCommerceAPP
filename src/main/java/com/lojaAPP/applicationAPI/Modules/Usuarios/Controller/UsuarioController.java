package com.lojaAPP.applicationAPI.Modules.Usuarios.Controller;

import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoEnderecoDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.DTO.NovoUsuarioDTO;
import com.lojaAPP.applicationAPI.Modules.Usuarios.Services.UsuarioServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid NovoUsuarioDTO novoUsuarioDTO){
        usuarioServices.cadastrarCliente(novoUsuarioDTO);
        return ResponseEntity.status(201).body("Usuário foi criado com sucesso.");
    }

    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable long id){
        var response = usuarioServices.buscarUsuario(id);

        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable long id){
        usuarioServices.excluirUsuario(id);

        return ResponseEntity.status(200).body("Usuário foi excluído.");
    }

    @PostMapping(value = "/cadastrarEndereco/{id}")
    public ResponseEntity<?> cadastrarEndereco(@PathVariable long id, @RequestBody @Valid NovoEnderecoDTO novoEnderecoDTO){
        usuarioServices.cadastrarNovoEndereco(novoEnderecoDTO, id);
        return ResponseEntity.status(201).body("Novo endereço cadastrado com sucesso.");
    }

    @DeleteMapping(value = "/deleteEndereco/{ìd}")
    public ResponseEntity<?> deletarEndereco(@PathVariable long id){
        usuarioServices.excluirUsuario(id);
        return ResponseEntity.status(200).body("Endereço foi excluído.");
    }
}
