package program;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.http.ParseException;
import org.json.JSONException;

import model.Filmes;
import service.API_Filmes;

public class Teste {

	public static void main(String[] args) throws ParseException, JSONException, IOException {
		Scanner ler = new Scanner(System.in);
		
		API_Filmes apiF = new API_Filmes();
		HashMap<Integer, Filmes> filme = apiF.getFilmes();
		
		System.out.print(apiF.printFilmes(filme));
		while(true)
			System.out.print(apiF.getOpcao(filme));

	}

}
