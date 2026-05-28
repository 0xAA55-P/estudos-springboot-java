package com.anna.produtos.service;

import com.anna.produtos.model.Produto;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
  List<Produto> produtos = new ArrayList<>(List.of());

  public List<Produto> listarTodos() {
    return produtos;
  }

  public List<Produto> buscarPorCategoria(String categoria) {
    List<Produto> resultado = produtos.stream()
           .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
           .collect(Collectors.toList());

    return resultado;
  }

  public Produto criar(Produto novoProduto) {
    if (novoProduto.getNome() == null) {
      throw new IllegalArgumentException("Nome não pode ser vazio.");
    }

    produtos.add(novoProduto);
    return novoProduto;
  }
}
