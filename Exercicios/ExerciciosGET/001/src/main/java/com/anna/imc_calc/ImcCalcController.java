package com.anna.imc_calc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

 /**
  * /calcular_imc?peso=...&altura=...
  */

@RestController
public class ImcCalcController {
  @GetMapping("/calcular_imc")
  public ResponseEntity<ImcCalc> calcularImc(
    @RequestParam float peso,
    @RequestParam float altura
  ) {

    ImcCalc resultado = new ImcCalc(peso, altura);
    return ResponseEntity.ok(resultado);
  }
}
