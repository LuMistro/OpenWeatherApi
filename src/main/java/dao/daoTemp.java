/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import model.Temperatura;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Luiza Mistro
 */
public class daoTemp {

    private static Temperatura temperatura;

    public static Double retornaTemperatura() {
        String link = "http://api.openweathermap.org/data/2.5/weather?q=palho%C3%A7a,br&appid=a229614ea2dc0d9e7e48d2384b4d0779";
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(link);
        HttpResponse resposta;
        Gson gson = new Gson();

        try {
            resposta = closeableHttpClient.execute(get);
            HttpEntity entity = resposta.getEntity();
            String conteudo = EntityUtils.toString(entity);

            temperatura = gson.fromJson(conteudo, Temperatura.class);

        } catch (Exception e) {
        }
        return temperatura.getMain().getTemp();
    }
}
