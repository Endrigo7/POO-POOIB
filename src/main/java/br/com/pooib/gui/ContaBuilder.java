package br.com.pooib.gui;

import br.com.pooib.entidades.Cliente;
import br.com.pooib.entidades.Conta;
import br.com.pooib.util.SenhaUtil;

import java.util.Scanner;

public class ContaBuilder {
	
	public static Conta build(Scanner leTeclado) {
		Cliente cliente = ClienteBuilder.build(leTeclado);

		System.out.println("Digite a sua senha");
		String senha = leTeclado.next();
		String senhaHash = SenhaUtil.geraHash(senha);

		System.out.println("Digite valor do deposito inicial");
		double saldoInicial = leTeclado.nextDouble();

		String numero = Conta.gerarNumero();

		Conta conta = new Conta(numero, saldoInicial, cliente, senhaHash);
		return conta;
	}


}
