package com.anna.estrutura.controller;

import com.anna.estrutura.model.Tarefa;
import com.anna.estrutura.service.TarefaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
  // o Spring injeta automaticamwnte, DI
  private final TarefaService tarefaService;

  public TarefaController(TarefaService tarefaService) {
    this.tarefaService = tarefaService;
  }

  // GET /tarefas -> lista tudo
  @GetMapping
  public ResponseEntity<List<Tarefa>> listarTodas() {
    List<Tarefa> tarefas = tarefaService.listarTodas();
    return ResponseEntity.ok(tarefas);
  }

  // GET /tarefas/1 -> pega a com id 1
  @GetMapping("/{id}")
  public ResponseEntity<Tarefa> listarPorId(@PathVariable Long id) {
    Tarefa tarefa = tarefaService.buscarPorId(id);

    if (tarefa == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(tarefa);
  }

  // POST /tarefas -> cria nova tarefa
  @PostMapping
  public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
    try {
      Tarefa nova = tarefaService.criar(tarefa);
      return ResponseEntity
             .status(HttpStatus.CREATED)
             .body(nova);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build(); // 400 bad request
    }
  }
}
