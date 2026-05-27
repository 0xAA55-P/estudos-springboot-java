package com.anna.validation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioDTOController {
  List<UsuarioDTO> usuarios = new ArrayList<>(List.of());

  // POST /usuarios -> cria um novo usuario
  @PostMapping
  public ResponseEntity<UsuarioDTO> criarUsuario(@Valid @RequestBody UsuarioDTO usuario) {
    usuarios.add(usuario); // adiciona na lista de usuarios

    // retorna o status (201) e o corpo (o usuario criado)
    return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(usuario);
  }

  // GET /usuarios/listar -> exibe todos os usuariis
  @GetMapping("/listar")
  public ResponseEntity<List<UsuarioDTO>> listarTodos() {
    return ResponseEntity.ok(usuarios);
  }
}
