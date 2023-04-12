package Arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrarProdutos {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		
		ArrayList<Produto> produto = new ArrayList<Produto>();

		for(int i = 0; i < 4; i++) {
			Produto p = new Produto();
			
			System.out.println("Digite o nome do produto:\r");
			p.setNome(ler.next());
			
			System.out.println("Digite a quantidade do produto:\r");
			p.setQuantidade(ler.nextDouble());
			
			System.out.println("Digite o preco do produto:\r");
			p.setPreco(ler.nextDouble());
			
			produto.add(p);
		}
		
		String path = "C:\\Users\\logonrmlocal\\Desktop\\DDD_Arquivos\\Lista-Compras-Fiap.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for(Produto line: produto) {
                
                bw.write(line.getNome() + "," + line.getQuantidade() + "," + line.getPreco());
                
                bw.newLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

		
	}

}
