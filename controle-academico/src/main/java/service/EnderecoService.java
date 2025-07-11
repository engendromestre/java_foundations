package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import model.Endereco;

public class EnderecoService {
    public static void completarEnderecoViaCEP(Endereco endereco) throws IOException, InterruptedException {
        String cepLimpo = endereco.getCep().replace("-", "");
        String url = "https://viacep.com.br/ws/" + cepLimpo + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Endereco dadosAPI = gson.fromJson(response.body(), Endereco.class);

        // Preencher os dados dinâmicos
        endereco.setLogradouro(dadosAPI.getLogradouro());
        endereco.setBairro(dadosAPI.getBairro());
        endereco.setLocalidade(dadosAPI.getLocalidade());
        endereco.setUf(dadosAPI.getUf());
    }
}
