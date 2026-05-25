package com.anna.entity_response;

public class Pessoa {
  private String nome;
  private String email;
  private int idade;

  public Pessoa() {}

  public Pessoa(String nome, String email, int idade) {
    this.nome = nome;
    this.email = email;
    this.idade = idade;
  }

  public String getNome() { return nome; }
  public String getEmail() { return email; }
  public int getIdade() { return idade; }
}
