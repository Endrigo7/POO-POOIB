package br.com.pooib.gui;

import br.com.pooib.entidades.Cliente;

import java.util.Scanner;

public class ClienteBuilder {

	protected static Cliente build(Scanner leTeclado) {
		System.out.println("Digite o cpf do Cliente");
		String cpf = leTeclado.next();

		System.out.println("Digite o nome do Cliente");
		String nome = leTeclado.next();

		Cliente cliente = new Cliente(nome, cpf);
		return cliente;
	}
	
}
