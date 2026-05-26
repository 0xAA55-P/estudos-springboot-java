package com.anna.save_user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  List<UsuarioDTO> usuarios = new ArrayList<>(List.of());

  // POST /usuarios -> cria um novo usuario
  @PostMapping
  public ResponseEntity<UsuarioDTO> criarUsuario(@RequestBody UsuarioDTO usuario) {
    usuarios.add(usuario); // adiciona na lista de usuarios

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
