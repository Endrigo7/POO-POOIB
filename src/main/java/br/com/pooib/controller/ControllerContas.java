package br.com.pooib.controller;

import br.com.pooib.entidades.Conta;
import br.com.pooib.excecoes.ContaInexistenteException;
import br.com.pooib.repository.RepositorioContasArray;

import java.util.List;

public class ControllerContas {

	private static final RepositorioContasArray repositorioContasArray = new RepositorioContasArray();;

	public ControllerContas() {
	}

	public Conta procurar(String numero, String senha) {
		Conta conta = repositorioContasArray.procurar(numero, senha);

		if (conta == null) {
			throw new ContaInexistenteException("Numero da conta ou senha inválidos");
		}

		return conta;
	}

	public Conta procurar(String numero) {
		Conta conta = repositorioContasArray.procurar(numero);

		if (conta == null) {
			throw new ContaInexistenteException("Numero da conta " + numero + " é inválido");
		}

		return conta;
	}

	public void inserir(Conta novaConta) {
		repositorioContasArray.inserir(novaConta);
	}

	public void remover(String numero, String senha) {
		procurar(numero, senha);
		repositorioContasArray.remover(numero, senha);
	}

	public void atualizar(Conta conta) {
		procurar(conta.getNumero(), conta.getSenha());
		repositorioContasArray.atualizar(conta);
	}

	public List<Conta> procurarContas(String cpf) {
		return repositorioContasArray.procurarContas(cpf);
	}

	public List<Conta> procurarContasJava8(String cpf) {
		return repositorioContasArray.procurarContasJava8(cpf);
	}
}
