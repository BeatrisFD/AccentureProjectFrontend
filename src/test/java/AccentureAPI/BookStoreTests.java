package AccentureAPI;

import org.junit.Test;
import AccentureAPI.TestRule;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class BookStoreTests {

    @Test
    public void CreateUser(){
        String userUrl = "https://demoqa.com/Account/v1/User";
        String userBody = "{\"userName\": \"Alana\", \"password\": \"Senha123!\"}";
        Map<String, String> postHeaders = new HashMap<>();
        postHeaders.put("Content-Type", "application/json");

        System.out.println("--- Criando usuário ---");

        HttpResponse<String> userResponse = TestRule.sendPostRequest(userUrl, userBody, postHeaders);
        if (userResponse != null) {
            System.out.println("Status: " + userResponse.statusCode());
            System.out.println("Response Body: " + userResponse.body());
        }
        System.out.println("\n");
    }

    @Test
    public void AcessToken(){
        String url = "https://demoqa.com/Account/v1/GenerateToken";

        String username = "Alana";
        String password = "Senha123!";

        String jsonBody = String.format("{\"userName\": \"%s\", \"password\": \"%s\"}", username, password);

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            if (response.statusCode() == 200) {
                System.out.println("Token gerado com sucesso!");
            } else {
                System.out.println("Falha ao gerar o token. Verifique as credenciais.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UserAutorization(){
        String username = "Alana";
        String password = "Senha123!";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFsYW5hIiwicGFzc3dvcmQiOiJTZW5oYTEyMyEiLCJpYXQiOjE3NTgzMDkzMDF9.gb-f7WNqzC5oWYl5YYzLWW51Ts7b-R66k99K7WDfulU";

        String url = "https://demoqa.com/Account/v1/Authorized";

        String jsonBody = String.format("{\"userName\": \"%s\", \"password\": \"%s\"}", username, password);

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            if (response.statusCode() == 200) {
                System.out.println("Usuário está autorizado. Token válido.");
            } else if (response.statusCode() == 401) {
                System.out.println("Usuário não está autorizado. Token inválido ou credenciais incorretas.");
            } else {
                System.out.println("Erro na requisição.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BookList(){
        String url = "https://demoqa.com/BookStore/v1/Books";

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET() // O método .GET() indica uma requisição GET
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());

            if (response.statusCode() == 200) {
                System.out.println("Lista de livros obtida com sucesso!");
                System.out.println("Response Body: " + response.body());

            } else {
                System.out.println("Falha ao listar os livros.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AddBooks(){
        String userId = "5cb53124-cf82-48e6-ba4d-2a95e8950049";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFsYW5hIiwicGFzc3dvcmQiOiJTZW5oYTEyMyEiLCJpYXQiOjE3NTgzMDkzMDF9.gb-f7WNqzC5oWYl5YYzLWW51Ts7b-R66k99K7WDfulU";

        String url = "https://demoqa.com/BookStore/v1/Books";

        String gitPocketGuideIsbn = "9781449325862";
        String jsDesignPatternsIsbn = "9781449331818";

        String jsonBody = String.format(
                "{\"userId\": \"%s\", \"collectionOfIsbns\": [{\"isbn\": \"%s\"}, {\"isbn\": \"%s\"}]}",
                userId, gitPocketGuideIsbn, jsDesignPatternsIsbn
        );

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            if (response.statusCode() == 201) {
                System.out.println("Livros adicionados com sucesso!");
            } else {
                System.out.println("Falha ao adicionar os livros. Verifique o userId e o token.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UserDetails(){
        String userId = "5cb53124-cf82-48e6-ba4d-2a95e8950049";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFsYW5hIiwicGFzc3dvcmQiOiJTZW5oYTEyMyEiLCJpYXQiOjE3NTgzMDkzMDF9.gb-f7WNqzC5oWYl5YYzLWW51Ts7b-R66k99K7WDfulU";

        String url = String.format("https://demoqa.com/Account/v1/User/%s", userId);

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            if (response.statusCode() == 200) {
                System.out.println("Detalhes do usuário obtidos com sucesso!");
            } else if (response.statusCode() == 401) {
                System.out.println("Usuário não autorizado. Verifique o token ou se o usuário existe.");
            } else {
                System.out.println("Erro na requisição.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
