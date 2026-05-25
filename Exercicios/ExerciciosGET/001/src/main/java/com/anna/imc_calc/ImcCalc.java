package com.anna.imc_calc;

public class ImcCalc {
  private float imcCalculado;
  private String classificacao;

  public ImcCalc() {}

  public ImcCalc(float peso, float altura) {
    this.imcCalculado = peso / (altura * altura);
    this.classificacao = this.classificar(imcCalculado);
  }

  public String classificar(float imc) {
    if (imc < 18.5) return "Abaixo do Peso";
    if (imc < 25.0) return "Peso Normal";
    if (imc < 30.0) return "Obesidade Grau I";
    if (imc < 40.0) return "Obesidade Grau II";
    return "Obesidade Grau III";
  }

  public float getImc() { return imcCalculado; }
  public String getClassificacao() { return classificacao; }
}
