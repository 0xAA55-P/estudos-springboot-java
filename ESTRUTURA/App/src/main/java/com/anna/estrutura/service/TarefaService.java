package com.anna.estrutura.service;

import com.anna.estrutura.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// diz pro SpBoot que essa classe eh um service e pede para gerenciar ela
@Service
public class TarefaService {
  private final List<Tarefa> tarefas = new ArrayList<>(List.of());
  private final AtomicLong contador = new AtomicLong(0);

  public List<Tarefas> listarTodas() {
    return tarefas;
  }

  public Tarefa buscarPorId(Long id) {
    return tarefas.stream()
           .filter(t -> t.getId().equals(id))
           .findFirst()
           .orElse(null); // lancariamos uma excecao aqui
                         // mas é só um exemplo
  }

  public Tarefa criar(Tarefa tarefa) {
    // regra de negocio
    if (tarefa.getTitulo() == null) {
      throw new IllegalArgumentException("Titulo não pode ser vazio.");
    }

    tarefa.setId(contador.getAndIncrement());
    tarefas.add(tarefa);
    return tarefa;
  }
}
