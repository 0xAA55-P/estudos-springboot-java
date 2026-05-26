package com.anna.post_basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/usuarios") // novo: define o prefixo das rotas
public class UsuarioController {
  @PostMapping // define uma rota POST
  public ResponseEntity<String> criarUsuario(
    // @RequestBody diz ao spring para pegar o corpo json da requisição
    // e converter automaticamente para um objeto UsuarioDTO
    @RequestBody UsuarioDTO usuario
  ) {
    System.out.println("Usuário recebido: " + usuario.getNome());

    // ResponseEntity permite controlar o status http da resposta
    // 201 é o status pra criaçao bem sucedida... já expliquei isso.
    // Eu acho.
    return ResponseEntity
           .status(HttpStatus.CREATED)
           .body("Usuário " + usuario.getNome() + " criado com sucesso.");
  }
}
