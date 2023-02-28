package program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.json.*;

import model.Feriado;

public class API_Feriado {

	public static ArrayList<Feriado> getFeriado() throws ClientProtocolException, IOException {

		ArrayList<Feriado> feriado = new ArrayList<Feriado>();

		HttpGet request = new HttpGet("https://brasilapi.com.br/api/feriados/v1/2023");

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

				CloseableHttpResponse response = httpClient.execute(request)) {

			HttpEntity entity = response.getEntity();

			if (entity != null) {

				String result = EntityUtils.toString(entity);

				JSONArray payload = new JSONArray(result);

				for (int i = 0; i < payload.length(); ++i) {

					Feriado frd = new Feriado();

					JSONObject dataNome = payload.getJSONObject(i);
					frd.setDate(dataNome.getString("date"));
					frd.setName(dataNome.getString("name"));

					feriado.add(frd);
				}

			}
		}

		return feriado;
	}

	public void VerifyFeriado() throws ClientProtocolException, IOException {

		Scanner ler = new Scanner(System.in);
		ArrayList<Feriado> feriado = getFeriado();
		while(true) {
			boolean yn = true, yn1 = false;
			int n=0;
			String dataInput="";
			System.out.print("Digite uma data (dd-mm) Ex: 25-12 :");
			dataInput = ler.next();
			for (int i = 0; i < feriado.size(); ++i) {
				if ((dataInput.substring(0, 2).equals(feriado.get(i).getDate().substring(8, 10))) && (dataInput.substring(3, 5).equals(feriado.get(i).getDate().substring(5, 7)))) {
					System.out.print("Esse dia é: "+feriado.get(i).getName()+"\n");
						yn = false;
				}
				if(dataInput.substring(3, 5).equals(feriado.get(i).getDate().substring(5, 7)))
				yn1 = true;
			}
			if((yn) && (yn1)) {
				for(int j = 0; j < feriado.size(); ++j) {
					
					if (dataInput.substring(3, 5).equals(feriado.get(j).getDate().substring(5, 7))) {
						System.out.print("Neste mês ha os seguintes feriados: ");
						System.out.print("\n"+feriado.get(j).getName()+": "+feriado.get(j).getDate()+"\n");
					}
				}
			}
		}
		
	}

}
