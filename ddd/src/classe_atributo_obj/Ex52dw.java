package classe_atributo_obj;

import java.util.Scanner;

public class Ex52dw {

	   public static void main(String[] args) {
	        Scanner ler = new Scanner(System.in);
	        
	        Produto[] lista=new Produto[10];
	        int i=0;
	        do{
	            Produto x=new Produto();
	            
	            System.out.print("Digite o id do produto: \n");
	            x.id=ler.nextInt();
	            
	            System.out.print("Digite a descricao do produto: \n");
	            x.descricao=ler.next();
	            
	            System.out.print("Digite o valor do produto: \n");
	            x.valor=ler.nextDouble();
	            
	            System.out.print("Digite a quantidade do produto: \n");
	            x.quantidade=ler.nextDouble();
	            
	            lista[i]=x;
	            i++;            
	        }while(i<=9);
	        int j=0;
	        do{
	            if(lista[j].valor <100) {
	                System.out.printf("ID: %d\nDESCRICAO: %s\nVALOR: %.2f\nQUANTIDADE: %.2f\n\n",lista[j].id,lista[j].descricao,lista[j].valor,lista[j].quantidade);
	            }
	            j++;
	        }while(j<=9);



	   }



	}