package com.anna.put_request.service;

import com.anna.put_request.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
  List<Produto> produtos = new ArrayList(List.of());
  private Long proximoId = 1L;

  public ProdutoService() {
    produtos.add(new Produto(proximoId++, "Notebook", 3500.0, 10));
    produtos.add(new Produto(proximoId++, "Mouse", 150.0, 50));
    produtos.add(new Produto(proximoId++, "Teclado", 200.0, 30));
  }

  public List<Produto> listarTodos() {
    return produtos;
  }

  /**
   * O Optional diz "pode ser que exista um produto com esse ID, ou pode ser que não exista".
   * Veremos como tratar isso no Controller
   */
  public Optional<Produto> buscarPorId(Long id) {
    return produtos.stream()
           .filter(p -> p.getId().equals(id))
           .findFirst();
  }

  // PUT
  public Optional<Produto> atualizar(Long id, Produto dadosNovos) {
    return buscarPorId(id).map(produtoExistente -> {
      // substitui cada campo do prpduto encontrado
      produtoExistente.setNome(dadosNovos.getNome());
      produtoExistente.setPreco(dadosNovos.getPreco());
      produtoExistente.setQuantidade(dadosNovos.getQuantidade());

      // obs: o id não muda, ele vem da url

      return produtoExistente;
    });
  }
}
