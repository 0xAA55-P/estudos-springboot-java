package com.anna.put_exercise.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import java.util.concurrent.atomic.AtomicLong;

// nome, telefone, email e cidade

@Data
public class Contato {
  private static final AtomicLong contador = new AtomicLong(0);

  Long id;

  @NotBlank(message = "Nome não deve ser vazio")
  private String nome;

  @NotBlank(message = "Telefone não deve ser vazio")
  private String telefone;

  @NotBlank(message = "Email não deve ser vazio")
  private String email;

  @NotBlank(message = "Cidade não deve ser vazia")
  private String cidade;

  public Contato() {}

  public Contato(String nome, String telefone, String email, String cidade) {
    this.id = contador.getAndIncrement(); // id autoincrementa
    this.nome = nome;
    this.telefone = telefone;
    this.email = email;
    this.cidade = cidade;
  }
}
