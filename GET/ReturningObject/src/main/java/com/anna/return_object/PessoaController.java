package com.anna.return_object;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
   * Ao acessar a rota /pessoas, ele retorna as pessoaa da lista
   * pessoas formatado em um objeto JSON
   */
  @GetMapping("/pessoas")
  public List<Pessoa> listarTodas() {
    return pessoas;
  }
}
