package br.com.fiap.loja;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		String nome = "Loja FIAP Run";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = 	DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o código do produto desejado: ");
		Scanner scanner = new Scanner(System.in);
		int codigo = scanner.nextInt();
		scanner.close();
		
		if(codigo == 401) {
			System.out.println("Camiseta branca");
		} else if(codigo == 402) {
			System.out.println("Camiseta azul");
		} else if(codigo == 403) {
			System.out.println("Camiseta rosa");
		} else {
			System.out.println("Produto não encontrado");
		}
	}

}
