package com.anna.livros.service;

import com.anna.livros.model.Livro;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {
  List<Livro> livros = new ArrayList<>(List.of());

  public List<Livro> listarTodos() {
    return livros;
  }

  public Livro listarPorTitulo(String titulo) {
    return livros.stream()
           .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
           .findFirst()
           .orElse(null);
  }

  public List<Livro> listarPorGenero(String genero) {
    return livros.stream()
           .filter(l -> l.getGenero().equalsIgnoreCase(genero))
           .collect(Collectors.toList());
  }

  public List<Livro> listarAPartirDe(int ano) {
    return livros.stream()
           .filter(l -> l.getAno() > ano)
           .collect(Collectors.toList());
  }

  public Livro criar(Livro livro) {
    if (livro.getTitulo() == null) {
      throw new IllegalArgumentException("Nome não pode ser vazio");
    }

    livros.add(livro);
    return livro;
  }
}
