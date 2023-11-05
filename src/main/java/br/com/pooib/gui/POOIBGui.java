package br.com.pooib.gui;

import br.com.pooib.controller.ControllerContas;
import br.com.pooib.entidades.Conta;
import br.com.pooib.util.SenhaUtil;

import java.util.Scanner;

import static br.com.pooib.gui.Constantes.*;
import static br.com.pooib.gui.MenuUtil.imprimeMenu;

public class POOIBGui {
	
	private ControllerContas controllerConta;
	private Scanner leTeclado;

	public POOIBGui() {
		controllerConta = new ControllerContas();
		leTeclado = new Scanner(System.in);
	}
	
	public void start() {
		System.out.println("Bem vindo ao POO Internet Bank");
		System.out.println("----------------------------------");

		int opcao = -1;
		do {
			imprimeMenu();
			opcao = leTeclado.nextInt();

			switch (opcao) {
			case ABRIR_CONTA:
				Conta conta = ContaBuilder.build(leTeclado);
				controllerConta.inserir(conta);
				
				System.out.println("O numero da sua conta eh: " + conta.getNumero());
				break;
			case CONSULTA_SALDO:
				conta = buscarConta();
				if (conta != null) {
					System.out.println("seu saldo eh:" + conta.getSaldo());
				}

				break;
			case CREDITAR:
				conta = buscarConta();
				if (conta != null) {
					System.out.println("Digite o valor");
					double valor = leTeclado.nextDouble();

					conta.creditar(valor);
				}

				break;
			case DEBITAR:
				conta = buscarConta();
				if (conta != null) {
					System.out.println("Digite o valor");
					double valor = leTeclado.nextDouble();

					conta.debitar(valor);
				}

				break;
			case TRANSFERIR:
				conta = buscarConta();
				if (conta != null) {
					Conta contaDestino = buscarContaDestino();

					if (contaDestino != null) {
						System.out.println("Digite o valor");
						double valor = leTeclado.nextDouble();

						conta.transferir(contaDestino, valor);
					}
				}

				break;
			case SAIR:
				System.out.println("Obrigado por usa o  POO Internet Bank");
				System.out.println("-----------------------------------------");
				break;
			default:
				System.out.println("Opção invalida! Selecione novamente!");
				break;
			}

		} while (opcao != SAIR);

		leTeclado.close();
	}
	
	private Conta buscarConta() {
		System.out.println("Digite o numero da Conta");
		String numero = leTeclado.next();

		System.out.println("Digite a sua senha");
		String senha = leTeclado.next();
		String senhaHash = SenhaUtil.geraHash(senha);

		Conta conta = controllerConta.procurar(numero, senhaHash);
		if (conta != null) {
			return conta;
		}

		System.out.println("Conta " + numero + " não encontrada!");
		return null;
	}

	private Conta buscarContaDestino() {
		System.out.println("Digite o numero da Conta Destino");
		String numero = leTeclado.next();

		Conta conta = controllerConta.procurar(numero);

		if (conta != null) {
			return conta;
		}

		System.out.println("Conta " + numero + " não encontrada!");
		return null;
	}
	
}
