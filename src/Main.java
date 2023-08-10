import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try {
            System.out.println("Qual o CEP do endereço?");
            String busca = scanner.nextLine();

            String endereco = "https://viacep.com.br/ws/" + busca.replace(" ", "") + "/json/";
            System.out.println(endereco);


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            EnderecoViaCEP enderecoViaCEP = gson.fromJson(json, EnderecoViaCEP.class);
            System.out.println(enderecoViaCEP);

            Endereco cep = new Endereco(enderecoViaCEP);
            System.out.println("endereço convertido:\n");
            System.out.println(cep);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("O programa finalizou!");

    }

}