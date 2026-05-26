package com.anna.simple_todo_api;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Data
public class TarefaDTO {
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final AtomicInteger contador = new AtomicInteger(0);

  /**
   * nota: usamos Integer pro id ppis ele aceita null, e então
   * nos permite não incluir o id na requisição
   */
  private Integer id;
  private String nome;
  private String status;

  public TarefaDTO(String nome, String status, Integer id) {
    this.nome = nome;
    this.status = status;
    this.id = gerarId();
  }

  public static int gerarId() {
    return contador.incrementAndGet(); // autoincrementa o id
  }
}
