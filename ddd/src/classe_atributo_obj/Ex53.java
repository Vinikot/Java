package classe_atributo_obj;
import java.util.Scanner;
public class Ex53 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		Aluno[] listAluno=new Aluno[5];
		
		for(int i=0;i<=4;i++) {
			Aluno a=new Aluno();
			
			System.out.print("Digite seu ra: \n");
			a.ra=ler.next();
			
			System.out.print("Digite seu nome: \n");
			a.nome=ler.next();
			
			String[] m=new String[6];
			for(int j=0;j<=5;j++) {
				System.out.print("Digite suas materias: \n");
				m[j]=ler.next();
			}
			a.materias=m;
			
			System.out.print("Digite seu periodos('noturno' ou 'diurno'): \n");
			a.periodos=ler.next();
			
			listAluno[i]=a;
		}
		
		for(int h=0;h<=4;h++) {
			if(listAluno[h].periodos.toLowerCase() == "noturno" ) {
				System.out.printf("RA: %s\nNOME: %s\nMATERIAS: %s\nPERIODOS: %s\n\n",listAluno[h].ra,listAluno[h].nome,listAluno[h].materias,listAluno[h].periodos);
			}
		}

	}

}
