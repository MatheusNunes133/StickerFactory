package br.com.images.pokemon.Client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public String dataFinder(String url){

        try{
            var client = HttpClient.newHttpClient();

            var request = HttpRequest.newBuilder(URI.create(url)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        }catch (IOException | InterruptedException exception){
            throw new RuntimeException(exception);
        }

    }

}
