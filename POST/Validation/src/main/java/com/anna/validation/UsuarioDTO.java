package com.anna.validation;

import lombok.Data; // biblioteca pra reduzir boilerplate
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data // gera getters, setters, tostring... etc, automaticamente
public class UsuarioDTO {
  @NotBlank(message = "Nome não pode ser vazio")
  private String nome;

  @NotBlank(message = "Email não pode ser vazio")
  @Email(message = "Insira um email válido")
  private String email;

  @Min(value = 0, message = "Idade inválida")
  @Max(value = 120, message = "Idade inválida")
  private int idade;

  /**
   * @Min; Valor Minimo
   * @Max; Valor Maximo
   *
   * @NotBlank; Aquele campo nao deve ser vazio
   * @Email; Email em formato correto
   *
   * message; Uma mensagem informativa
   * veremos como exibir ela na resposta depoisr
   *
   * Existem outros, dê uma olhada na web.
   */
}
