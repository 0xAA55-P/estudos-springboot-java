package com.anna.basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Declara que essa classe recebe e trata requisicoes web
 */
@RestController
public class OlaController {
  // define uma rota, que ao ser acessada, executa
  // a função ola
  @GetMapping("/ola")
  public String ola() {
    return "Olá, todos!";
  }

  // define uma rota, que ao ser acessada, executa
  // a funcao olaMundo
  @GetMapping("/ola/mundo")
  public String olaMundo() {
    return "Olá, Mundo!";
  }

  // define uma rota, que ao ser acessada, executa
  // a função olaSpr
  @GetMapping("/ola/spring-boot")
  public String olaSpr() {
    return "Olá, SpringBoot!";
  }
}
