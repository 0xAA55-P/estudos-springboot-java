package com.anna.return_object;

public class Pessoa {
  private String nome;
  private String email;
  private int idade;

  /**
   * Este construtor vazio ésado pelo jackson ou pelo JPA
   * para instanciar o objeto
   */
  public Pessoa() {}

  public Pessoa(String nome, String email, int idade) {
    this.nome = nome;
    this.email = email;
    this.idade = idade;
  }

  /**
   * Os getters são necessários, pois o jackson precisa dos getters
   * para conseguir ler os campos
   *
   * jackson: Biblioteca que o spring usa para serializar objetos em json
   */
  public String getNome() { return nome; }
  public String getEmail() { return email; }
  public int getIdade() { return idade; }
}
