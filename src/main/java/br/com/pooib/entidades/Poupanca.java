package br.com.pooib.entidades;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Poupanca extends Conta{

    private static final double TAXA_DE_JUROS = 0.05;

    public void renderJuros(){
        double rendimento = getSaldo() * TAXA_DE_JUROS;
        creditar(rendimento);
    }
}
