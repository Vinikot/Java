package program;

import java.io.IOException;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


import org.json.*;

public class ConvertService {
   
    public double getConversao(double valorReal, int moeda) throws ClientProtocolException, IOException {
       
    	HttpGet request = null;
    	double moedaconvert1 = 0;
    	String moedaSelect = "";
       
    	if(moeda==1) {
    		request = new HttpGet("https://economia.awesomeapi.com.br/json/last/USD-BRL");
    		moedaSelect = "USDBRL";
    	}else if(moeda==2) {
    		request = new HttpGet("https://economia.awesomeapi.com.br/json/last/EUR-BRL");
    		moedaSelect = "EURBRL";
    	}else if(moeda==3) {
    		request = new HttpGet("https://economia.awesomeapi.com.br/json/last/BTC-BRL");
    		moedaSelect = "BTCBRL";
    	}
    		
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
               
                CloseableHttpResponse response = httpClient.execute(request)) {
           
            HttpEntity entity = response.getEntity();
           
            if(entity != null) {
               
                String result = EntityUtils.toString(entity);
               
                JSONObject requestJ = new JSONObject(result);
               
                moedaconvert1 = requestJ.getJSONObject(moedaSelect).getDouble("ask");
            }
        }
        double valorConvert = valorReal / moedaconvert1 ; 
       
        return valorConvert;
    }
}

