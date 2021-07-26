package br.com.ufrn.sistemabancario.conta;

import java.util.ArrayList;

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
				contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
			}
		}
	}
	
	public void cebitarConta (int numero, float valor) {
		
		for(int i = 0; i < contas.size(); i++) {
			if(numero == contas.get(i).getNumero()) {
				contas.get(i).setSaldo(contas.get(i).getSaldo() - valor);
			}
		}
	}
}
