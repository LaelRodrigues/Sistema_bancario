package br.com.ufrn.sistemabancario.conta;

public class Conta {
	
	private int numero;
	private float saldo;
	
	public Conta() {}
	
	public Conta(int numero, float saldo) {
		super();
		this.numero = numero;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + Float.floatToIntBits(saldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		if (Float.floatToIntBits(saldo) != Float.floatToIntBits(other.saldo))
			return false;
		return true;
	}
}
