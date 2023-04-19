package CadastrarPedidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		ArrayList<Pedido> pedido = new ArrayList<Pedido>();
		char continuar = 'n';

		System.out.println(":::SISTEMA DE CADASTRO DE PEDIDOS:::\n");

		do {
			Pedido p = new Pedido();
			int quantidadeProdutos = 0;

			System.out.println("Digite a quantidade de produtos desejado:\r");
			quantidadeProdutos = ler.nextInt();
			p.setQuantProds(quantidadeProdutos);

			ArrayList<String> nomeProduto = new ArrayList<String>();
			ArrayList<Double> quantidadeProduto = new ArrayList<Double>();
			ArrayList<Double> precoProduto = new ArrayList<Double>();

			System.out.println("Digite o seu nome:\r");
			p.setPedName(ler.next());

			for (int i = 0; i < quantidadeProdutos; i++) {

				System.out.println("Digite o nome do produto:\r");
				nomeProduto.add(ler.next());

				System.out.println("Digite a quantidade do produto:\r");
				quantidadeProduto.add(ler.nextDouble());

				System.out.println("Digite o preco do produto:\r");
				precoProduto.add(ler.nextDouble());
			}

			p.setNome(nomeProduto);
			p.setQuantidade(quantidadeProduto);
			p.setPreco(precoProduto);
			pedido.add(p);

			System.out.println("Deseja cadastrar um novo pedido? (s/n)\n");
			continuar = ler.next().charAt(0);

		} while (continuar == 's');

		String path = "C:\\Users\\logonrmlocal\\Desktop\\pedidos.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (Pedido line : pedido) {
				bw.newLine();

				bw.write(line.getPedName());
				bw.newLine();

				for (int i = 0; i < line.getQuantProds(); i++) {
					bw.write(line.getNome().get(i) + "," + line.getQuantidade().get(i) + "," + line.getPreco().get(i));
					bw.newLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		FileReader fr = null;
		BufferedReader br = null;

		String path2 = "C:\\Users\\logonrmlocal\\Desktop\\total_pedidos.txt";

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();
			double lineTotal, lineTotalPed = 0;
			String nome = null;

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {

				while (line != null) {
					if (line.isEmpty()) {
						nome = br.readLine();
						line = br.readLine();
						System.out.print(nome);
					} else {

						while (line != null && !line.isEmpty() && Character.isDigit(line.charAt(line.length() - 1))) {
							String[] lineDados = line.split(",");
							lineTotal = (Double.parseDouble(lineDados[1]) * Double.parseDouble(lineDados[2]));
							lineTotalPed += lineTotal;
							line = br.readLine();
						}

						bw.write(nome + " - R$" + lineTotalPed);
						bw.newLine();
						lineTotalPed = 0;
						
					}
				}
			} catch (Exception e) {
				System.out.print(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
