package com.anna.put_request.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
  private Long id;
  private String nome;
  private Double preco;
  private Integer quantidade;
}
