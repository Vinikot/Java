package classe_atributo_obj;

import java.util.Scanner;

public class Ex51dw {

	   public static void main(String[] args) {
	        Scanner ler = new Scanner(System.in);
	        
	        Cliente[] lista=new Cliente[5];
	        int i=0;
	         do{
	            Cliente x=new Cliente();
	            
	            System.out.print("Digite o id: \n");
	            x.id=ler.nextInt();
	            
	            System.out.print("Digite o nome: \n");
	            x.nome=ler.next();
	            
	            System.out.print("Digite o idade: \n");
	            x.idade=ler.nextInt();
	            
	            System.out.print("Digite o email: \n");
	            x.email=ler.next();
	            
	            lista[i]=x;
	            i++;            
	        }while(i<=4);
	        int j=0;
	         do{
	            if(lista[j].idade >18) {
	                System.out.printf("ID: %d\nNOME: %s\nIDADE: %d\nEMAIL: %s\n\n",lista[j].id,lista[j].nome,lista[j].idade,lista[j].email);
	            }
	            j++;
	            
	        }while(j<=4);



	   }



	}