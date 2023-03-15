package service;

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

import model.Filmes;

public class API_Filmes {

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
}
