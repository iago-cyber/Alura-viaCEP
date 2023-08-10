import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaViaCEP {
    public EnderecoViaCEP busca(String cep){

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep.replace(" ", "") + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), EnderecoViaCEP.class);

        } catch (Exception e) {
            throw new RuntimeException("Não pude encontrar o CEP.");
        }
    }
}
