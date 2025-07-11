package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import model.Endereco;

public class EnderecoService {
    public static Endereco buscarEnderecoPorCEP(String cep) throws IOException, InterruptedException {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(response.body(), Endereco.class);

        return endereco;
    }
}
