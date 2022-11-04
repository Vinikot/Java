package Ex59;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex59 {

	public static void main(String[] args) {
		Scanner ler=new Scanner(System.in);
		
		ArrayList<Cliente> listaCliente=new ArrayList<>();
		
		int opc;
		
		do {
			System.out.printf("===> Sistema de Cadastro de Clientes <===\n\n");
			System.out.printf("Escolha uma opção:\n");          
			System.out.printf("1 - Cadastrar Cliente \n" +
                             	"2 - Criar Conta Bancaria \n" +
                             	"3 - Sacar \n" +
                             	"4 - Depositar \n" +
                             	"5 - Transferir \n" +
                             	"6 - Sair\n\n");
	 
	           System.out.printf("Digite a opção desejada: ");
	           opc = ler.nextInt();
	           
	           if(opc==1) {
	        	   
	           }
	           
	           
	           
		}while(opc!=5);
		
	}

}
