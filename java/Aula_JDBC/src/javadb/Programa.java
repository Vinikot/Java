package javadb;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		AlunosDB adb = new AlunosDB();

		while (true) {
			int opc = 0;

			System.out.print("::::SISTEMA DE CADASTRO DE ALUNOS::::\n\n");
			System.out.print("1 - Incluir alunos\r\n" + "2 - Atualizar alunos\r\n" + "3 - Excluir alunos\r\n" + "4 - Listar alunos\r\n" + "5 - Listar um aluno\r\n" + "");
			System.out.print("DIGITE A OPCAO DESEJADA:\r\n");
			opc = ler.nextInt();

			try {
				if (opc == 1) {
					Alunos a = new Alunos();

					System.out.println("DIGITE O ID DO ALUNO:");
					a.setId(ler.nextInt());

					System.out.println("DIGITE O NOME DO ALUNO:");
					a.setNome(ler.next());

					System.out.println("DIGITE O RA DO ALUNO:");
					a.setRa(ler.next());

					System.out.println("DIGITE O CURSO DO ALUNO:");
					a.setCurso(ler.next());

					adb.IncluirAlunoDB(a);
				} else if (opc == 2) {
					ArrayList<Alunos> listaAlunos = adb.ReturnAlunosDB();

					System.out.println("DIGITE O ID DO ALUNO QUE DESEJA ATUALIZAR:");
					int id = ler.nextInt();
					
					System.out.println("DIGITE O NOVO CURSO DO ALUNO:");
					String curso = ler.next();
					
					for(Alunos a: listaAlunos) {
						if(a.getId() == id) {
							a.setCurso(curso);
							adb.AtualizarAlunosDB(a);
						}
					}
					
				} else if (opc == 3) {
					
					System.out.println("DIGITE O ID DO ALUNO QUE DESEJA EXCLUIR:");
					int id = ler.nextInt();
					
					adb.ExcluirAlunosDB(id);
					
				} else if (opc == 4) {
					adb.ListarAlunosDB();
				}
				else
					break;
			}catch(Exception e) {
				e.getStackTrace();
			}
		}

	}

}
