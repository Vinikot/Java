package service;

import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.json.*;

import model.Comentarios;
import model.Filmes;

public class API_Filmes {

	Integer idC = 0;
	Scanner ler = new Scanner(System.in);
	
	public HashMap<Integer, Filmes> getFilmes() throws JSONException, ParseException, IOException {
		HashMap<Integer, Filmes> filme = new HashMap<Integer, Filmes>();

		HttpGet request = new HttpGet("https://sujeitoprogramador.com/r-api/?api=filmes");

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

				CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();

			if (entity != null) {

				String result = EntityUtils.toString(entity);

				JSONArray payload = new JSONArray(result);

				for (int i = 0; i < payload.length(); ++i) {

					Filmes flm = new Filmes();

					JSONObject dataNome = payload.getJSONObject(i);
					flm.setId(dataNome.getInt("id"));
					flm.setNome(dataNome.getString("nome"));
					flm.setSinopse(dataNome.getString("sinopse"));

					filme.put(flm.getId(), flm);
				}

			}
		}

		return filme;

	}
	
	public String printFilmes(HashMap<Integer, Filmes> filme) {
		
		String listaFilmes = "Lista dos Filmes em Cartaz: \n";
		
		for(Integer id: filme.keySet()) {
			listaFilmes += ("\nID: "+id+"  ||  "+filme.get(id).getNome());
		}
		
		return(listaFilmes);
	}
	
	public String getOpcao(HashMap<Integer, Filmes> filme){	
		
		System.out.print("\nEscolha uma opção:\r\n"
				+ "\r\n"
				+ "1 - Ver detalhes do filme\r\n"
				+ "2 - Fazer um comentário do filme\r\n"
				+ "3 - Excluir um comentário\r\n"
				+ "");
		int opc = ler.nextInt();
		int id;
		
		if(opc == 1) {
			
			String detalhesFilme;
			
			System.out.print("Digite o id do filme: ");
			id = Integer.valueOf(ler.nextInt());
			
			detalhesFilme = "\nSinopse: "+filme.get(id).getSinopse();
			
			if(filme.get(id).getComentario() != null) {
				detalhesFilme = "Comentários:";
				for(Integer idComentario: filme.get(id).getComentario().keySet()) {
					detalhesFilme += "\nID Comentário: "+filme.get(id).getComentario().get(idComentario).getId()+"  ||  Nome: "+filme.get(id).getComentario().get(idComentario).getNome()+"  ||  Comentário: "+filme.get(id).getComentario().get(idComentario).getComentario();
				}
			}
			else
				detalhesFilme += "\nEsse filme não possui comentários.";
				
			return detalhesFilme;
		}
		else if(opc == 2) {
			
			HashMap<Integer, Comentarios> com = new HashMap<Integer, Comentarios>();
			
			Comentarios c = new Comentarios();
			
			System.out.print("Digite o id do filme: ");
			id = Integer.valueOf(ler.nextInt());
			System.out.print("Digite o seu Nome: ");
			c.setNome(ler.next());
			System.out.print("Digite o seu Comentário: ");
			c.setComentario(ler.next());
			c.setId(idC+Integer.valueOf(1));
			com.put(c.getId(), c);
			filme.get(id).setComentario(com);
			return "Comentário adicionado com sucesso!";
		}
		else if(opc == 3) {
			
			String detalhesFilme = null;
			
			System.out.print("Digite o id do filme: ");
			id = Integer.valueOf(ler.nextInt());
			
			if(filme.get(id).getComentario() != null) {
				detalhesFilme = "Comentários:";
				for(Integer idComentario: filme.get(id).getComentario().keySet()) {
					detalhesFilme += "\nID Comentário: "+filme.get(id).getComentario().get(idComentario).getId()+"  ||  Nome: "+filme.get(id).getComentario().get(idComentario).getNome()+"  ||  Comentário: "+filme.get(id).getComentario().get(idComentario).getComentario();
				}
				System.out.print(detalhesFilme);
				System.out.print("\nDigite o id do Comentário que deseja excluir: ");
				Integer idCom = Integer.valueOf(ler.nextInt());
				filme.get(id).getComentario().remove(idCom);
				return "Comentário excluido com sucesso!";
			}
			else {
				detalhesFilme += "\nEsse filme não possui comentários.";
				return detalhesFilme;
			}
		}
		else 
			return "";	
		
	}
	
}
