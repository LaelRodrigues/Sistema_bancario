package br.com.ufrn.sistemabancario.main;

import java.util.Scanner;

import br.com.ufrn.sistemabancario.conta.GerenciarContas;

public class Main {

	public static void main(String[] args) {
		
		int escolha = 0;
		int numeroConta;
		float valor;
		try (Scanner ler = new Scanner( System.in)) {
			GerenciarContas contas = new GerenciarContas();
			
			do {
				System.out.println("--------------------------------------------");
				System.out.println("--------------Sistema Bancario--------------");
				System.out.println("--------------------------------------------");
				System.out.println("1 - Cadastrar uma conta");
				System.out.println("2 - Consultar saldo da conta");
				System.out.println("3 - Creditar valor em uma conta");
				System.out.println("4 - Debitar valor em uma conta");
				System.out.println("5 - Efetuar transferencia entre duas conta");
				System.out.println("6 - Cadastrar uma conta poupanca");
				System.out.println("7 - Render juros nas contas do tipo poupanca");
				System.out.println("0 - Sair do sistema");
				System.out.println("Digite um numero: ");
				escolha = ler.nextInt();
				
				switch(escolha) {	
					case 0:
						System.out.println();
						System.out.println("Saida do sistema efetuada com sucesso.");
						break;
						
					case 1:
						System.out.println();
						System.out.println("Digite o numero da conta: ");
						numeroConta = ler.nextInt();
						contas.cadastrarConta(numeroConta);
						System.out.println();
						System.out.println("Conta cadastrada com sucesso.");
						break;
						
					case 2:
						System.out.println();
						System.out.println("Digite o numero da conta: ");
						numeroConta = ler.nextInt();
						System.out.println();
						System.out.printf("O saldo atual da conta é de: %.3f R$ ", contas.consultarSaldo(numeroConta));
						System.out.println();
						break;
					
					case 3:
						System.out.println();
						System.out.print("Digite o numero da conta: ");
						numeroConta = ler.nextInt();
						System.out.println();
						System.out.println("Digite o valor a ser creditado da conta: ");
						valor = ler.nextFloat();
						contas.creditarConta(numeroConta, valor);
						System.out.println();
						System.out.println("Valor creditado com sucesso.");
						break;
					
					case 4:
						System.out.println();
						System.out.print("Digite o numero da conta: ");
						numeroConta = ler.nextInt();
						System.out.println();
						System.out.println("Digite o valor a ser debitado da conta: ");
						valor = ler.nextFloat();
						contas.debitarConta(numeroConta, valor);
						System.out.println();
						System.out.println("Valor debitado com sucesso.");
						break;
					
					case 5:
						System.out.println();
						System.out.print("Digite o numero da conta origem: ");
						numeroConta = ler.nextInt();
						System.out.print("Digite o numero da conta destino: ");
						int numeroConta2 = ler.nextInt();
						System.out.println();
						System.out.println("Digite o valor da trasferencia: ");
						valor = ler.nextFloat();
						contas.efetuarTrasferencia(numeroConta, numeroConta2, valor);
						System.out.println();
						System.out.println("trasferencia efetuada com sucesso.");
						break;
					
					case 6:
						System.out.println();
						System.out.println("Digite o numero da conta: ");
						numeroConta = ler.nextInt();
						contas.criarContaPoupanca(numeroConta);
						System.out.println();
						System.out.println("Conta poupanca cadastrada com sucesso.");
						break;
					
					case 7:
						System.out.println();
						System.out.println("Digite o valor da taxa de juros: ");
						valor = ler.nextFloat();
						contas.renderJuros(valor);
						System.out.println();
						System.out.println("juros adicionados com sucesso.");
					
					default:
						System.out.println("Numero invalido");
				}
				System.out.println();
				System.out.println("Digite 1 para continuar ou 0 para sair do sistema:");
				escolha = ler.nextInt();
				System.out.println();
				if(escolha ==  0) {
					System.out.println("Saida do sistema efetuada com sucesso.");
				}
				}while(escolha != 0);
		}
	}

}