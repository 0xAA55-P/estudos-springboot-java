package com.anna.persistencia.repository;

import com.anna.persistencia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Ao estender JpaRepository<Produto, Long>, o Spring gera automaticamente os metodos:
 * save(), findById(), findAll(), deleteById(), existsById(), count()... etc
 *
 * O segundo tipo genérico (Long) é o tipo do @Id da entidade
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  // Podemos declarar querys customizadas só pelo nome do metodo
  // o spring interpreta e gera o sql
  public List<Produto> findByNomeContainingIgnoreCase(String nome);
  public List<Produto> findByPrecoBetween(Double min, Double max);
}
