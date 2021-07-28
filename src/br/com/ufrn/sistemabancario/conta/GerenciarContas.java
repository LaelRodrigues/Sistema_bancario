package br.com.ufrn.sistemabancario.conta;

import java.util.ArrayList;
import  java.lang.reflect.Field;  

public class GerenciarContas {
	 
	private ArrayList<Conta> contas;
	
	public GerenciarContas() {
		
		contas = new ArrayList<>();
	}

	public GerenciarContas(ArrayList<Conta> contas) {
		
		super();
		this.contas = contas;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		
		this.contas = contas;
	}
	
	public void cadastrarConta(int numero) {
		
		Conta conta = new Conta(numero, 0.0f);
		contas.add(conta);
	}
	public float consultarSaldo(int numero) {
		
		for(int i = 0; i < contas.size(); i++) {
			if(numero == contas.get(i).getNumero()) {
				return contas.get(i).getSaldo();
			}
		}
		return -1;
	}
	
	public void creditarConta(int numero, float valor) {
		
		for(int i = 0; i < contas.size(); i++) {
			if(numero == contas.get(i).getNumero()) {
				if(contas.get(i) instanceof ContaBonus) {
					ContaBonus conta = (ContaBonus) contas.get(i);
					conta.setSaldo(conta.getSaldo() + valor);
					conta.setPontuacao(conta.getPontuacao() + (int)valor/(int)100);
				} else {
					contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
				}
			}
		}
	}
	
	public void debitarConta (int numero, float valor) {
		
		for(int i = 0; i < contas.size(); i++) {
			if(numero == contas.get(i).getNumero()) {
				contas.get(i).setSaldo(contas.get(i).getSaldo() - valor);
			}
		}
	}
	
	public void efetuarTrasferencia(int numeroConta1, int numeroConta2 , float valor) {
		
		Conta contaOrigem = null;
		Conta contaDestino = null;
		
		for(int i = 0; i < contas.size(); i++) {
			if(numeroConta1 == contas.get(i).getNumero()) {
				contaOrigem = contas.get(i);
			}
			if(numeroConta2 == contas.get(i).getNumero()) {
				contaDestino = contas.get(i);
			}
		}
		
		contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
		if(contaDestino instanceof ContaBonus) {
			ContaBonus contaBonus = (ContaBonus) contaDestino;
			contaBonus.setSaldo(contaBonus.getSaldo() + valor);
			contaBonus.setPontuacao(contaBonus.getPontuacao() + ((int)valor/(int)200));
		} else {
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
		}
	}
	
	public void criarContaBonus(int numero) {
		
		ContaBonus conta = new ContaBonus(numero, 0.0f, 10);
		contas.add(conta);
	}
}
