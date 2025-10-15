package com.dev.brexchangeapi.config.impl;

import com.dev.brexchangeapi.config.AwesomeApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AwesomeApiImpl implements AwesomeApi {
    @Value("${awesomeapi.key}")
    private String API_KEY;
    @Value("${awesomeapi.baseurl}")
    private String BASE_URL;

    public String seekQuote(String coinsCode) {
        String url = BASE_URL + coinsCode;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;
        String urlWithToken = url + "?token=" + API_KEY;

        System.out.println("Conectando à URL: " + urlWithToken);
        request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(urlWithToken))
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                return response.body();
            }else{
                System.err.println("Falha na conexão. Código de status: " + response.statusCode());
                System.err.println("Resposta da API: " + response.body());
            }
        }catch(IOException | InterruptedException e){
            System.err.println("Ocorreu um erro ao fazer a requisição: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
