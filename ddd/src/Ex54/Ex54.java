package Ex54;
import java.util.Scanner;
public class Ex54 {

	public static void main(String[] args) {
		Scanner ler=new Scanner(System.in);
		
		char cb;
		String agencia, numero;
		double saldo;
		
		Cliente[] listaCliente=new Cliente[5];
		
		for(int i=0;i<=4;i++) {
			Cliente a=new Cliente();
			
			System.out.print("Digite seu ID: ");
			a.setId(ler.nextInt());
			
			System.out.print("Digite seu nome: ");
			a.setNome(ler.next());
			
			System.out.print("Digite sua idade: ");
			a.setIdade(ler.nextInt());
			
			System.out.print("Digite seu email: ");
			a.setEmail(ler.next());
				
			System.out.print("Possui conta bancaria? (APENAS 's' OU 'n'): ");
			cb=ler.next().charAt(0);
			
			if(cb =='s') {
				System.out.print("Digite sua agencia bancaria: ");
				agencia=ler.next();
				
				System.out.print("Digite seu numero: ");
				numero=ler.next();
				
				System.out.print("Digite seu saldo: ");
				saldo=ler.nextDouble();
				
				ContaBancaria b=new ContaBancaria(agencia, numero, saldo);
				a.setConta(b);
			}else {
				ContaBancaria b=null;
				a.setConta(b);
			}
			
			listaCliente[i]=a;
		}
		
		for(int i=0;i<=4;i++) {
			System.out.println(listaCliente[i].exibirNomeIdade());
			if(listaCliente[i].getConta()!=null) {
				System.out.println(listaCliente[i].exibirDadosConta());
			}
		}
	}

}
