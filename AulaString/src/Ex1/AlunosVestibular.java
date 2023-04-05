package Ex1;

import java.util.HashMap;

public class AlunosVestibular {

	public static void main(String[] args) {
		String alunosVestibular = "Jose dos Santos,7,Sao Paulo;Sandra Silva,6.5,Sao Jose do Rio Preto;Augusto Soares,8,Sao Paulo;Vanderlei Azevedo,5.65,Santos;Vanessa Ferreira,9,Sao Paulo;Natan Cruz,10,Sao Paulo.";
		String[] listaAlunos = alunosVestibular.split(";");
		HashMap<Integer, String[]> alunoPassaram = new HashMap<Integer, String[]>();
		for (String i : listaAlunos) {
			String[] listaTemp = (((i.split(",")[1].getBytes()[0] > 54) && (i.split(",")[1].getBytes()[0] < 58)) || (i.split(",")[1].getBytes()[1] == 48)? i.split(",") : null);
			alunoPassaram.put(i.length(), listaTemp);
		}

		System.out.println("ALUNOS QUE PASSARAM: \n");
		alunoPassaram.forEach((key, value) -> {
			if (value != null) {
				System.out.printf("NOME: %s\nNOTA: %s\nCIDADE: %s\n\n", value[0], value[1], value[2]);
			}
		});

	}

}
