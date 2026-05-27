package com.anna.produtos;

import lombok.Data;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Data
public class ProdutoDTO {
  @NotBlank(message = "Nome Do Produto Vazio")
  private String nome;

  @Min(value = 0, message = "Preço não pode ser 0")
  @Positive(message = "Preço não pode ser negativo")
  private float preco;

  @NotBlank(message = "Insira uma categoria")
  private String categoria;

  @Positive(message = "Estoque não pode ser negativo")
  private static int estoque;

  private boolean disponivel;

  public ProdutoDTO(String nome, float preco, String categoria, int estoque) {
    this.nome = nome;
    this.preco = preco;
    this.categoria = categoria;
    this.estoque = estoque;
    this.disponivel = produtoEstaDisponivel();
  }

  public static boolean produtoEstaDisponivel() {
    return estoque > 0;
  }
}
