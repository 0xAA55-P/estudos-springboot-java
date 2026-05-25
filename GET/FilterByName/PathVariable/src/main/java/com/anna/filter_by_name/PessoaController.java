package com.anna.filter_by_name;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
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

  /**
   * Ao acessar /pessoas, retorna todas as pessoas na lista
   */
  @GetMapping("/pessoas")
  public ResponseEntity<List<Pessoa>> listarTodas() {
    return ResponseEntity.ok(pessoas);
  }

  // GET /pessoas/Anna retorna informações da Anna
  /**
   * A anotação PathVariable é usada para extrair
   * values do caminho da URL
   */
  @GetMapping("/pessoas/{nome}")
  public ResponseEntity<Pessoa> listarPorNome(@PathVariable String nome) {
    return pessoas.stream()
           .filter(p -> p.getNome().equalsIgnoreCase(nome))
           .findFirst()
           .map(p -> ResponseEntity.ok(p))
           .orElse(ResponseEntity.notFound().build());

    /**
     * .filter -> filtra somente as pessoas onde getNome for igual ao nome passado na url
     * .findFirst -> encontra a primeira ocorrencia
     * .map -> se findFirst achar, transforma em um EntityResponse<Pessoa> e retorna 200
     * .orElse -> Se nao encontrou, cai aqui e retorna 404
     *
     * obs: o map aqui não é o mesmo de listas/streams
     * é o map do Optional
     */
  }
}
