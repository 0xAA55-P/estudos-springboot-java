package com.anna.save_user;

import lombok.Data; // biblioteca pra reduzir boilerplate

@Data // gera getters, setters, tostring... etc, automaticamente
public class UsuarioDTO {
  private String nome;
  private String email;
  private int idade;
}
