package Ex63;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);
		
		ArrayList<PessoaJuridica> listaPJ=new ArrayList<>();
		ArrayList<PessoaFisica> listaPF=new ArrayList<>();
		int opc;
		
		do {
			System.out.printf("----> SISTEMA DE CADASTRO DE PESSOAS <----\n\n1 - Pessoa Fisica\n2 - Pessoa Juridica\n3 - Sair\n\nSelecione a opção desejada.");
			opc=ler.nextInt();
			
			if(opc==1) {
				PessoaFisica pf=new PessoaFisica();
				
				System.out.printf("Digite seu nome: ");
				pf.setNome(ler.next());
				
				System.out.printf("Digite sua idade: ");
				pf.setIdade(ler.nextInt());
				
				System.out.printf("Digite seu email: ");
				pf.setEmail(ler.next());
				
				System.out.printf("Digite seu cpf: ");
				pf.setCpf(ler.nextInt());
				
				listaPF.add(pf);
				
				System.in.read();
			}
			else if(opc==2) {
					PessoaJuridica pj=new PessoaJuridica();
					
					System.out.printf("Digite seu nome: ");
					pj.setNome(ler.next());
					
					System.out.printf("Digite sua idade: ");
					pj.setIdade(ler.nextInt());
					
					System.out.printf("Digite seu email: ");
					pj.setEmail(ler.next());
					
					System.out.printf("Digite sua cnpj: ");
					pj.setCnpj(ler.nextInt());
					
					listaPJ.add(pj);
					
					System.in.read();
			}
		}while(opc!=3);

	}

}
