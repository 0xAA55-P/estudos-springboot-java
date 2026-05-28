package com.anna.produtos.controller;

import com.anna.produtos.model.Produto;
import com.anna.produtos.service.ProdutoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  // GET /produtos -> Lista todos
  @GetMapping
  public ResponseEntity<List<Produto>> listarTodos() {
    List<Produto> produtos = produtoService.listarTodos();
    return ResponseEntity.ok(produtos);
  }

  // GET /produtos/categoria -> lista apenas da categoria infantil
  @GetMapping("/{categoria}")
  public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable String categoria) {
    List<Produto> resultado = produtoService.buscarPorCategoria(categoria);
    return ResponseEntity.ok(resultado);
  }

  /**
   * POST /produtos Cria um produto
   *
   * @param produto O novo produto a criar
   * @return O produto criado com status 201 ou 400 Bad Request
   */
  @PostMapping
  public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
    try {
      Produto resultado = produtoService.criar(produto);

      return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(resultado);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
