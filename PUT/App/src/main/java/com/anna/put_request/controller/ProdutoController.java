package com.anna.put_request.controller;

import com.anna.put_request.model.Produto;
import com.anna.put_request.service.ProdutoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  @GetMapping
  public List<Produto> listarTodos() {
    return produtoService.listarTodos();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
    return produtoService.buscarPorId(id)
           .map(ResponseEntity::ok) // se achou, retorna 200 Ok com o produto
           .orElse(ResponseEntity.notFound().build()); // se não achou, retorna 404 Not Found
  }

  @PutMapping("/{id}")
  public ResponseEntity<Produto> atualizarProduto(
    @PathVariable Long id, // id eh recebido na url, nao requisição
    @RequestBody Produto produto) {
    return produtoService.atualizar(id, produto)
           .map(ResponseEntity::ok)
           .orElse(ResponseEntity.notFound().build());
  }
}
