package com.anna.produtos.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
  @NotBlank(message = "Nome não pode ser vazio")
  private String nome;

  @NotBlank(message = "Categoria não pode ser vazia")
  private String categoria;

  @Positive(message = "O preço deve ser positivo")
  private float preco;

  @Positive(message = "O estoque deve ser positivo")
  private int estoque;

  public boolean isDisponivel() {
    return this.estoque > 0;
  }
}
