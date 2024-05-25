import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObterDados {
    public static double converterDados(String base_code, String target_code, double valor) throws IOException, InterruptedException {

        URI converter = URI.create("https://v6.exchangerate-api.com/v6/36e2d87069c1d210fcc74028/pair/" + base_code + "/" + target_code + "/" + valor);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(converter)))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Dados dados = gson.fromJson(response.body(), Dados.class);
                return valor * dados.conversion_rate();
            }
        } catch (Exception e) {
            System.err.println("Erro ao processar solicitação: " + e.getMessage());
        }
        return -1;

    }
}
