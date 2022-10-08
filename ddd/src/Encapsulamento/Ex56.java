package Encapsulamento;

import java.util.Scanner;

public class Ex56 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		Produto[] listaProduto=new Produto[5];
		
		for(int i=0;i<=4;i++) {
			Produto a=new Produto();
			Categoria b=new Categoria();
			
			System.out.print("");
			a.setId(ler.nextInt());
			
			System.out.print("");
			a.setNome(ler.next());
			
			System.out.print("");
			a.setPreco(ler.nextDouble());
			
			System.out.print("");
			a.setQuantidade(ler.nextDouble());
			
			char r;
			System.out.print("");
			r=ler.next().charAt(0);
			
			if(r=='s') {
				System.out.print("");
				b.setId(ler.nextInt());
				
				System.out.print("");
				b.setNome(ler.next());
				
				a.setCategoria(b);
				
			} else {
				b=null;
				a.setCategoria(b);
			}
			listaProduto[i]=a;
		}
		
		for(int i=0;i<=4;i++) {
			System.out.println(listaProduto[i].exibirNomePrecoQuantidade());
			if(listaProduto[i].getCategoria()!=null) {
				System.out.println(listaProduto[i].exibirCategoria());
			}
		}
	}

}
