package com.anna.persistencia.service;

import com.anna.persistencia.model.Produto;
import com.anna.persistencia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
  private final ProdutoRepository repository;

  public ProdutoService(ProdutoRepository repository) {
    this.repository = repository;
  }

  public List<Produto> listarTodos() {
    return repository.findAll();
    // equivalente a SELECT * FROM produtos
  }

  public Optional<Produto> buscarPorId(Long id) {
    return repository.findById(id); // encontra o produto com o id passado
    // equivalente a SELECT * FROM produtos WHERE id = ?
  }

  public Produto salvar(Produto produto) {
    // pode implementar validação aaqui tambek
    return repository.save(produto);
  }

  public Produto atualizar(Long id, Produto produto) {
    // busca o produto existente pelo id
    // lança RuntimeException se nao encontrar
    Produto existente = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));

    // atualiza os dados
    existente.setNome(produto.getNome());
    existente.setPreco(produto.getPreco());
    existente.setDescricao(produto.getDescricao());

    return repository.save(existente);
    // save faz UPDATE quando o id ja existe
  }

  public void deletar(Long id) {
    repository.deleteById(id); // deleta o produto com aquele id
    // DELETE * FROM produtos WHERE id = ?
  }

  public List<Produto> buscarPorNome(String nome) {
    return repository.findByNomeContainingIgnoreCase(nome);
  }
}
