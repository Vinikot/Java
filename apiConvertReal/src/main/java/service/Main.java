package service;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;

import program.ConvertService;

public class Main {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		Scanner ler = new Scanner(System.in);
		
		ConvertService cs = new ConvertService();
		
		double valorConvert;
		int moeda;
		
		System.out.printf("Digite um valor em Real: ");
		valorConvert = ler.nextDouble();
		
		System.out.printf("Deseja converter para:\n 1 - Dolar\n 2 - Euro\n 3 - Bitcoin\n\nSelecione uma moeda: ");
		moeda = ler.nextInt();
		
		System.out.print("Resultado: " + cs.getConversao(valorConvert, moeda));

	}

}
