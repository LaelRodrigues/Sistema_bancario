package br.com.ufrn.sistemabancario.conta;

public class ContaBonus extends Conta{
	
	private int pontuacao;
	
	public ContaBonus(int numero, float saldo, int pontuacao) {
		super(numero, saldo);
		this.pontuacao = pontuacao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
