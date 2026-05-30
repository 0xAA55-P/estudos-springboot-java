package com.anna.persistencia.controller;

import com.anna.persistencia.model.Produto;
import com.anna.persistencia.service.ProdutoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
  private final ProdutoService service;

  public ProdutoController(ProdutoService service) {
    this.service = service;
  }

  // GET /api/produtos -> lista todos
  // GET /api/produtos?nome=cafe -> filtra por nome
  // mais um conceito interessante, 2 coisas em uma unica rota
  @GetMapping
  public List<Produto> listar(@RequestParam(required = false) String nome) {
    if (nome != null) {
      return service.buscarPorNome(nome);
    }
    return service.listarTodos();
  }

  // GET /api/produtos/1 -> lista produto com id especifico
  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
    return service.buscarPorId(id)
           .map(ResponseEntity::ok)
           .orElse(ResponseEntity.notFound().build());
  }

  // POST /api/produtos -> cria um novo produto
  @PostMapping
  public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
    Produto salvo = service.salvar(produto);
    return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(salvo);
  }

  // PUT /api/produtos/1 -> atualiza produto existente
  @PutMapping("/{id}")
  public ResponseEntity<Produto> atualizar(
    @PathVariable Long id, @RequestBody Produto novosDados) {
    try {
      return ResponseEntity.ok(service.atualizar(id, novosDados));
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  // DELETE /api/produtos/1 -> deleta um produto existente
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    service.deletar(id);
    return ResponseEntity.noContent().build(); // 204 no content
  }
}
