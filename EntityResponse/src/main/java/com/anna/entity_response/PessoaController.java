package com.anna.entity_response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
   * ResponseEntity permite controlar codigos de status,
   * headers e corpo.
   *
   * Componentes:
   *  1. Codigo de Status HTTP
   *  Indica o retorno de uma requisição HTTP
   *
   *  201 OK: Requisição processada com sucesso
   *  201 Created: Um novo recurso foi criado com sucesso
   *  204 No Content: Req. concluída com sucesso, mas sem corpo
   *  400 Bad Request: Requisiçãi Mal formada/Inválida
   *  404 Not Found: Recurso da requisição não encontrado
   *  500 Internal Server Erro: Servidor falhou pra processar
   *
   *  2. Headers HTTP
   *  Oferecem metadados da resposta.
   *
   *  Content-Type: Indica o formato da resposta. Ex: application/json
   *  Authorization: Usado para enviar credenciais para autenticação
   *  Custom Headers: O dev pode definir headers customizados
   *
   *  3. Corpo da Resposta (Response Body)
   *  Contem o conteudo principal da resposta. Pode ser:
   *
   *  Um Objeto JSON
   *  Texto Puro
   *  HTML se retorna uma pagina
   *  Vazio se nenhum conteudo é necessário
   */
  @GetMapping("/pessoas")
  public ResponseEntity<List<Pessoa>> listarTodas() {
    return ResponseEntity.ok(pessoas);
  }
}
