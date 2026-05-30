package com.anna.persistencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @Entity Diz ao JPA que essa classe eh uma tabela no banco
 * @Table Define o nome da tabela (opcional  mas recomendado)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {
  /**
   * @Id Marca a chave primária
   * @GeneratedValue AutoIncrementa, fazendo o banco gerar o id automaticamente
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false) // NOT NULL na tabela
  private String nome;

  @Column(nullable = false)
  private Double preco;

  @Column(length = 500) // limita o tamanho
  private String descricao;
  
}
