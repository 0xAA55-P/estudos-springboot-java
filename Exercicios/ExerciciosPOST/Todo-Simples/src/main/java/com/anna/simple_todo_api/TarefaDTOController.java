package com.anna.simple_todo_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaDTOController {
  List<TarefaDTO> tarefas = new ArrayList<>(List.of());

  // GET /tarefas/todas -> retorna todas as tarefas salvas
  @GetMapping("/todas")
  public ResponseEntity<List<TarefaDTO>> listarTodas() {
    return ResponseEntity.ok(tarefas);
  }

  // GET /tarefas/id/1 -> retorna apenas a tarefa com id 1
  @GetMapping("/id/{id}")
  public ResponseEntity<TarefaDTO> listarPorId(@PathVariable int id) {
    return tarefas.stream()
           .filter(t -> t.getId() == id)
           .findFirst()
           .map(t -> ResponseEntity.ok(t))
           .orElse(ResponseEntity.notFound().build());
  }

  // POST /tarefas/criar -> cria uma tarefa
  @PostMapping("/criar")
  public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO novaTarefa) {
    tarefas.add(novaTarefa);

    return ResponseEntity
           .status(HttpStatus.CREATED)
           .body(novaTarefa);
  }
}
