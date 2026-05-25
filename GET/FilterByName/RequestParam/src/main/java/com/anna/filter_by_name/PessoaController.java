package com.anna.filter_by_name;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PessoaController {
  List<Pessoa> pessoas = new ArrayList<>(
    List.of(
      new Pessoa("Anna", "anna@email.com", 16),
      new Pessoa("Lucca", "lucca@email.com", 17),
      new Pessoa("Bob", "bob@email.com", 18)
    )
  );

  // retorna todas as pess9as
  @GetMapping("/pessoas")
  public ResponseEntity<List<Pessoa>> listarTodas() {
    return ResponseEntity.ok(pessoas);
  }

  /**
   * Retorna uma pessoa especifica.
   * Uso: /pessoas/filtrar?nome=Anna
   *
   * A diferença pro PathVariable é que RequestParam é opcional.
   * É usado geralmente para parametros opcionais ou pesquisas.
   *
   * Para entender a lógica do return, leia a segunda pasta nesse Diretório. 
   */
  @GetMapping("/pessoas/filtrar")
  public ResponseEntity<Pessoa> buscarPorNome(@RequestParam String nome) {
    return pessoas.stream()
           .filter(p -> p.getNome().equalsIgnoreCase(nome))
           .findFirst()
           .map(p -> ResponseEntity.ok(p))
           .orElse(ResponseEntity.notFound().build());
  }
}
