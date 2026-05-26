package com.anna.post_basics;

/**
 * Essa classe representa os campos que
 * o cliente vai enviar no corpo da requisicao
 */
public class UsuarioDTO {
  private String nome;
  private String email;
  private int idade;

  public UsuarioDTO() {}

  public UsuarioDTO(String nome, String email, int idade) {
   this.nome = nome;
   this.email = email;
   this.idade = idade; 
  }

  /**
   * Getters e setters sao obrigatorios para o spring
   * conseguir ler e escrever nos campos
   */
  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public int getIdade() { return idade; }
  public void setIdade(int idade) { this.idade = idade; }
  
}
