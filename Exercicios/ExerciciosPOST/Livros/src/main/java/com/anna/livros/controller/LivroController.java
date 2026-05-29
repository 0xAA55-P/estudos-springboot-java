package com.anna.livros.controller;

import com.anna.livros.model.Livro;
import com.anna.livros.service.LivroService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.stream.Collector;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
  LivroService livroService;

  public LivroController(LivroService livroService) {
    this.livroService = livroService;
  }

  // GET /livros -> lista todos
  @GetMapping
  public ResponseEntity<List<Livro>> listarTodos() {
    List<Livro> livros = livroService.listarTodos();
    return ResponseEntity.ok(livros);
  }

  // GET /livros/1984 -> lista o livro de nome 1984
  @GetMapping("/{titulo}")
  public ResponseEntity<Livro> listarPorTitulo(@PathVariable String titulo) {
    Livro livro = livroService.listarPorTitulo(titulo);
    return ResponseEntity.ok(livro);
  }

  // GET /livros/genero?genero=romance -> mostra apenas romance
  @GetMapping("/genero")
  public ResponseEntity<List<Livro>> listarPorGenero(@RequestParam String genero) {
    List<Livro> livros = livroService.listarPorGenero(genero);
    return ResponseEntity.ok(livros);
  }

  // GET /livros/apos_ano?ano=2000 -> livros depois dos anos 2000
  @GetMapping("/apos_ano")
  public ResponseEntity<List<Livro>> listarAPartirDe(@RequestParam int ano) {
    List<Livro> livros = livroService.listarAPartirDe(ano);
    return ResponseEntity.ok(livros);
  }

  // POST /livros -> cria um novo livro
  @PostMapping
  public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
    try {
      Livro resultado = livroService.criar(livro);

      return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(livro);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }
}
