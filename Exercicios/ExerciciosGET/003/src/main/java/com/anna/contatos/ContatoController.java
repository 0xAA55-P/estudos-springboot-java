package com.anna.contatos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ContatoController {
  List<Contato> contatos = new ArrayList<>(
    List.of(
      new Contato("Anna", "11-23333-4444", "anna@email.com", "cidade 1"),
      new Contato("Lucca", "22-34444-5555", "lucca@email.com", "cidade 2"),
      new Contato("Bob", "33-45555-6666", "bob@email.com", "cidade 2")
    )
  );

  // GET /contatos -> exibe todos os contatos
  @GetMapping("/contatos")
  public ResponseEntity<List<Contato>> listarTodos() {
    return ResponseEntity.ok(contatos);
  }

  // GET /contatos/Anna -> retorna só a Anna
  @GetMapping("/contatos/nome/{nome}")
  public ResponseEntity<Contato> listarPorNome(@PathVariable String nome) {
    return contatos.stream()
           .filter(c -> c.getNome().equalsIgnoreCase(nome))
           .findFirst()
           .map(c -> ResponseEntity.ok(c))
           .orElse(ResponseEntity.notFound().build());
  }

  // GET /contatos/cidade?cidade=Cidade 2 -> retorna as pessoas da cidade 2
  @GetMapping("/contatos/buscar/cidade")
  public ResponseEntity<List<Contato>> listarPorCidade(@RequestParam String cidade) {
    List<Contato> resultado = contatos.stream()
           .filter(c -> c.getCidade().equalsIgnoreCase(cidade.trim()))
           .collect(Collectors.toList());

    if (resultado.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(resultado);
  }

  // GET /contatos/email -> lista apenas os emails
  @GetMapping("/contatos/emails")
  public ResponseEntity<List<String>> listarEmails() {
    List<String> emails = contatos.stream()          
           .map(c -> c.getEmail())
           .collect(Collectors.toList());

    return ResponseEntity.ok(emails);
  }
}
