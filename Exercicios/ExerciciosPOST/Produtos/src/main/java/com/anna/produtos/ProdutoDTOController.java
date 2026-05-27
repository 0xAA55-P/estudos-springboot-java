package com.anna.produtos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoDTOController {
  List<ProdutoDTO> produtos = new ArrayList<>(List.of());

  // POST /produtos -> adiciona um novo produto
  @PostMapping
  public ResponseEntity<ProdutoDTO> criarProduto(@Valid @RequestBody ProdutoDTO novoProduto) {
    produtos.add(novoProduto);

    return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(novoProduto);
  }

  // GET /produtos/todos -> lista todos os produtos
  @GetMapping("/todos")
  public ResponseEntity<List<ProdutoDTO>> listarTodos() {
    return ResponseEntity.ok(produtos);
  }

  // GET /produtos/categoria?categoria=infantil
  // lista apenas produtos da categoria infantil
  @GetMapping("/categoria")
  public ResponseEntity<List<ProdutoDTO>> listarPorCategoria(@RequestParam String categoria) {
    List<ProdutoDTO> resultado = produtos.stream()
           .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
           .collect(Collectors.toList());

    if (resultado.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(resultado);
  }
}
