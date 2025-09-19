package util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class TestRule {
    private static final HttpClient client = HttpClient.newHttpClient();

    public static HttpResponse<String> sendPostRequest(String url, String body, Map<String, String> headers) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body));
        headers.forEach(requestBuilder::header);
        try {
            HttpRequest request = requestBuilder.build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao enviar requisição POST para " + url);
            e.printStackTrace();
            return null;
        }
    }

    public static HttpResponse<String> sendGetRequest(String url, Map<String, String> headers) {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET();
        headers.forEach(requestBuilder::header);
        try {
            HttpRequest request = requestBuilder.build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao enviar requisição GET para " + url);
            e.printStackTrace();
            return null;
        }
    }
}
