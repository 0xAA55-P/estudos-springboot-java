package com.anna.put_exercise.service;

import com.anna.put_exercise.model.Contato;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class ContatoService {
  List<Contato> contatos = new ArrayList<>(List.of());

  /**
   * Lista todos os contatos.
   * Metodo: GET
   *
   * @return A lista com os contatos
   */
  public List<Contato> listarTodos() {
    return contatos;
  }

  /**
   * Lista um contato pelo nome
   * Metodo: GET
   *
   * @param nome O nome a buscar
   * @return O contato encontrado
   */
  public Optional<Contato> listarPorNome(String nome) {
    return contatos.stream()
         .filter(c -> c.getNome().equalsIgnoreCase(nome))
         .findFirst();
    }

  /**
   * Lista todos os contatos de uma cidade especifica
   * Metodo GET
   *
   * @param cidade O nome da cidade
   * @return Os contatos daquela cidade
   */
  public List<Contato> listarPorCidade(String cidade) {
    return contatos.stream()
           .filter(c -> c.getCidade().equalsIgnoreCase(cidade))
           .collect(Collectors.toList());
  }

  /**
   * Lista apenas os emails dos contatos
   *
   * @param A lista com os emails
   */
  public List<String> listarEmails() {
    return contatos.stream()
           .map(c -> c.getEmail())
           .collect(Collectors.toList());
  }

  /**
   * Lista um contato pelo seu ID
   *
   * @param id O id a buscar
   * @return O contato encontrado
   */
  public Optional<Contato> listarPorId(Long id) {
    return contatos.stream()
           .filter(c -> c.getId().equals(id))
           .findFirst();
  }

  /**
   * Adiciona um contato a lista
   *
   * @param contato O novo contato a adicionar
   * @return O contato recem criado
   */
  public Contato criar(Contato contato) {
    if (contato.getNome() == null || contato.getNome().isEmpty()) {
      throw new IllegalArgumentException("Nome não pode ser vazio");
    }

    contatos.add(contato);
    return contato;
  }

  /**
   * Edita um contato da lista
   *
   * @param id O id do contato a ediyar
   * @param novosDados Os novos dados do contato
   */
  public Optional<Contato> editar(Long id, Contato novosDados) {
    if (novosDados.getNome() == null || novosDados.getNome().isEmpty()) {
      throw new IllegalArgumentException("Nome não pode ser vazio");
    }

    return listarPorId(id).map(contatoExistente -> {
      contatoExistente.setNome(novosDados.getNome());
      contatoExistente.setTelefone(novosDados.getTelefone());
      contatoExistente.setEmail(novosDados.getEmail());
      contatoExistente.setCidade(novosDados.getCidade());

      return contatoExistente;
    });
  }
}
