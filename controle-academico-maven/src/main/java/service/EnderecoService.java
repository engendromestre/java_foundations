package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Endereco;

public class EnderecoService {
    public static void completarEnderecoViaCep(Endereco endereco) throws IOException, InterruptedException {
        String cepLimpo = endereco
                .getCep()
                .replace("-", "");
        // ! = Não
        if(!isValido(cepLimpo)) {
            throw new IllegalArgumentException("Formato de CEP inválido");
        }

        String url = "https://viacep.com.br/ws/" + cepLimpo + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());

        // Capturar o erro caso ele ocorra
        JsonObject json = JsonParser
                .parseString(response.body())
                .getAsJsonObject();
        
        if(json.has("erro") && json.get("erro").getAsBoolean()) {
            throw new IllegalArgumentException("CEP inválido");
        }

        Gson gson = new Gson();
        Endereco dadosAPI = gson.fromJson(response.body(), Endereco.class);

        // Preencher os dados dinamicamente
        endereco.setLogradouro(dadosAPI.getLogradouro());
        endereco.setBairro(dadosAPI.getBairro());
        endereco.setLocalidade(dadosAPI.getLocalidade());
        endereco.setUf(dadosAPI.getUf());
    }


    private static boolean isValido(String cep) {
        // REGEX - Expressões Regulares
        // 18600-000
        // 18600000
        String REGEX_CEP = "^\\d{5}-?\\d{3}$";
        return cep != null && cep.matches(REGEX_CEP);
    }
}
