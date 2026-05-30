package com.anna.put_exercise.controller;

import com.anna.put_exercise.model.Contato;
import com.anna.put_exercise.service.ContatoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
  ContatoService contatoService;

  public ContatoController(ContatoService contatoService) {
    this.contatoService = contatoService;
  }

  // GET /contatos -> lista todos
  @GetMapping
  public List<Contato> listarTodos() {
    return contatoService.listarTodos();
  }

  // GET /contatos/Anna -> retorna somente o contato Anna
  @GetMapping("/{nome}")
  public ResponseEntity<Contato> listarPorNome(@PathVariable String nome) {
    return contatoService.listarPorNome(nome)
           .map(ResponseEntity::ok)
           .orElse(ResponseEntity.notFound().build());
  }

  // GET /contatos/cidade?cidade=Cidade 1
  // lista contatos da cidade 1
  @GetMapping("/cidade")
  public List<Contato> listarPorCidade(@RequestParam String cidade) {
    return contatoService.listarPorCidade(cidade);
  }

  // GET /contatos/emails -> lista todos os contatoa
  @GetMapping("/emails")
  public List<String> listarEmails() {
    return contatoService.listarEmails();
  }

  // POST /contatos -> cria um novo contato
  @PostMapping
  public ResponseEntity<Contato> criar(@RequestBody Contato contato) {
    try {
      Contato contatoCriado = contatoService.criar(contato);

      return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(contato);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  // PUT /contatos/1 -> edita o contato com id 1
  @PutMapping("/{id}")
  public ResponseEntity<Contato> editar(
    @PathVariable Long id,
    @RequestBody Contato contato
  ) {
    try {
      return contatoService.editar(id, contato)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());

    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
