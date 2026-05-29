package com.anna.livros.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
  @NotBlank(message = "Titulo não pode ser vazio")
  private String titulo;

  @NotBlank(message = "Autor não pode ser vazio")
  private String autor;

  @NotBlank(message = "Genero não pode ser vazio")
  private String genero;

  private int ano;
}
